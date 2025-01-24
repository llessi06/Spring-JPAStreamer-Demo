package com.example.demo.personManagement.data;

import com.example.demo.personManagement.database.entity.AddressEntity;
import com.example.demo.personManagement.rest.resource.AddressResource;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String id;
    private String street;
    private String city;
    private String state;
    private String zip;

    public AddressResource toResource() {
        return new AddressResource(id, street, city, state, zip);
    }

    public AddressEntity toEntity() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(id);
        addressEntity.setStreet(street);
        addressEntity.setCity(city);
        addressEntity.setState(state);
        addressEntity.setZip(zip);
        return addressEntity;
    }
}
