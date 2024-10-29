package ru.mxmztsv.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private String status;
    private String category;
    private Date createdAt;
}
