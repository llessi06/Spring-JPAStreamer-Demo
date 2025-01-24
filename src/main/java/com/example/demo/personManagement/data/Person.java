package com.example.demo.personManagement.data;

import com.example.demo.personManagement.database.entity.PersonEntity;
import com.example.demo.personManagement.rest.resource.PersonResource;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
    private String email;
    private String phone;
    private Address address;

    public PersonResource toResource() {
        return new PersonResource(id, name, email, phone, address.toResource());
    }

    public PersonEntity toEntity() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(id);
        personEntity.setName(name);
        personEntity.setEmail(email);
        personEntity.setPhone(phone);
        personEntity.setAddress(address.toEntity());
        return personEntity;
    }
}
