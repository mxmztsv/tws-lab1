package ru.mxmztsv.model.soap;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Data;
import ru.mxmztsv.model.category;
import ru.mxmztsv.model.status;

@Data
@XmlRootElement(name = "searchClientsRequest")
@XmlType(name = "SearchClientsRequest", namespace = "http://app.mxmztsv.ru/")
public class SearchClientsRequest {
    private String firstName;
    private String lastName;
    private status status;
    private category category;

    public String toString(){
        return "First Name: " + firstName + " Last Name: " + lastName + " Status: " + status;
    }
}
