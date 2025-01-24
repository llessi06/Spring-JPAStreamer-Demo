package com.example.demo.personManagement.rest.dto;

import com.example.demo.personManagement.data.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address toData() {
        return new Address(null, street, city, state, zip);
    }
}
