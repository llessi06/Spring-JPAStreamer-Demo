package com.example.demo.personManagement.rest.resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressResource {
    private String id;
    private String street;
    private String city;
    private String state;
    private String zip;
}
