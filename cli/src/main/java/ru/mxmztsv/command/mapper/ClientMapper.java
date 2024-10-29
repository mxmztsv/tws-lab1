package ru.mxmztsv.command.mapper;

import ru.mxmztsv.app.model.SearchClientsResponseModelType;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientMapper {

    public static final SimpleDateFormat DATA_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat DATA_FORMAT_SERVER = new SimpleDateFormat("yyyy-MM-dd");

    public static String mapToString(SearchClientsResponseModelType Client) {
        try {
            return "Client -> " + "\n" +
                    "\t Id: " + Client.getId() + "\n" +
                    "\t Name: " + Client.getFirstName() + "\n" +
                    "\t Last name: " + Client.getLastName() + "\n" +
                    "\t Status: " + Client.getStatus() + "\n" +
                    "\t Category: " + Client.getCategory() + "\n" +
                    "\t Created at: " + DATA_FORMAT.format(DATA_FORMAT_SERVER.parse(Client.getCreatedAt())) + "\n";
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
