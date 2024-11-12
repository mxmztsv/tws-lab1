package ru.mxmztsv.app;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import lombok.extern.slf4j.Slf4j;
import ru.mxmztsv.app.domain.DatabaseExecutor;
import ru.mxmztsv.app.domain.Client;
import ru.mxmztsv.model.category;
import ru.mxmztsv.model.status;
import ru.mxmztsv.model.soap.ClientSearchResponse;
import ru.mxmztsv.model.soap.SearchClientsResponseModel;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@WebService(serviceName = "ClientService", portName = "ClientServicePort")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ClientServiceImpl {

    private static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DatabaseExecutor databaseExecutor;

    public ClientServiceImpl(DataSource dataSource) {
        this.databaseExecutor = new DatabaseExecutor(dataSource);
    }

    @WebMethod
    @WebResult(name = "ClientSearchResponse", targetNamespace = "http://app.mxmztsv.ru/")
    public ClientSearchResponse searchClients(
            @WebParam(name = "firstName")
            String firstName,
            @WebParam(name = "lastName")
            String lastName,
            @WebParam(name = "status")
            status status,
            @WebParam(name = "category")
            category category,
            @WebParam(name = "data")
            String data
    ) throws ParseException {
        StringBuilder query = new StringBuilder("SELECT * FROM Clients WHERE 1=1");
        List<Object> params = new ArrayList<>();
        addStringParam(firstName, "first_name", query, params);
        addStringParam(lastName, "last_name", query, params);
        if (data != null && !data.isEmpty()) {
            addStringParamDate(DATA_FORMAT.format(DATA_FORMAT.parse(data)), "created_at", query, params);
        }
        addEnumParam(status, "status", query, params);
        addEnumParam(category, "category", query, params);
        return ClientSearchResponse.builder()
                .responseModelList(databaseExecutor.executeSelect(query.toString(), params).stream()
                        .map(ClientServiceImpl::mapToSearchResponse).collect(Collectors.toList()))
                .build();
    }

    private void addStringParam(String value, String name, StringBuilder query, List<Object> params) {
        if (value != null && !value.isEmpty()) {
            query.append(" AND ").append(name).append(" = ?");
            params.add(value);
        }
    }

    private void addStringParamDate(String value, String name, StringBuilder query, List<Object> params) {
        if (value != null && !value.isEmpty()) {
            query.append(" AND ").append(name).append(" = CAST(? AS DATE)");
            params.add(value);
        }
    }

    private void addEnumParam(Object value, String name, StringBuilder query, List<Object> params) {
        if (value != null) {
            query.append(" AND ").append(name).append(" = ?");
            params.add(value);
        }
    }

    private static SearchClientsResponseModel mapToSearchResponse(Client Client) {
        return SearchClientsResponseModel.builder()
                .id(Client.getId())
                .firstName(Client.getFirstName())
                .lastName(Client.getLastName())
                .status(status.valueOf(Client.getStatus()))
                .category(category.valueOf(Client.getCategory()))
                .createdAt(DATA_FORMAT.format(Client.getCreatedAt()))
                .build();
    }
}


