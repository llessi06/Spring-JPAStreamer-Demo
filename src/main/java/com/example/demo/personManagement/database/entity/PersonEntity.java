package com.example.demo.personManagement.database.entity;

import com.example.demo.personManagement.data.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Setter
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = AddressEntity.class)
    private AddressEntity address;

    public Person toData() {
        return new Person(id, name, email, phone, address.toData());
    }
}
