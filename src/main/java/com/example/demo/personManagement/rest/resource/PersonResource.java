package com.example.demo.personManagement.rest.resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonResource {
    private String id;
    private String name;
    private String email;
    private String phone;
    private AddressResource address;
}
