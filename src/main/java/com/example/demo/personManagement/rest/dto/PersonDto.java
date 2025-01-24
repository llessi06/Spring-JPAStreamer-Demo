package com.example.demo.personManagement.rest.dto;

import com.example.demo.personManagement.data.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {
    private String name;
    private String email;
    private String phone;
    private AddressDto address;

    public Person toData() {
        return new Person(null, name, email, phone, address.toData());
    }
}
