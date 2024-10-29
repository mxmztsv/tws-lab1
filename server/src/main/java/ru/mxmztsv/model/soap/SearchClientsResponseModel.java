package ru.mxmztsv.model.soap;

import jakarta.xml.bind.annotation.XmlType;
import lombok.Builder;
import lombok.Data;
import ru.mxmztsv.model.category;
import ru.mxmztsv.model.status;

@Data
@Builder
@XmlType(name = "SearchClientsResponseModelType", namespace = "http://app.mxmztsv.ru/model")
public class SearchClientsResponseModel {
    private int id;
    private String firstName;
    private String lastName;
    private status status;
    private category category;
    private String createdAt;
}
