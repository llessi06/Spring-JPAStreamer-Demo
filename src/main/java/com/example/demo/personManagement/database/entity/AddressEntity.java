package com.example.demo.personManagement.database.entity;

import com.example.demo.personManagement.data.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Setter
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zip;

    public Address toData() {
        return new Address(id, street, city, state, zip);
    }
}
