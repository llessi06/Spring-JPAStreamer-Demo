package com.example.demo.personManagement;

import com.example.demo.personManagement.data.Person;
import com.example.demo.personManagement.database.entity.PersonEntity;
import com.example.demo.personManagement.database.entity.PersonEntity$;
import com.example.demo.personManagement.database.repository.AddressRepository;
import com.example.demo.personManagement.database.repository.PersonRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class PersonManager {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private JPAStreamer jpaStreamer;

    public List<Person> getAllPersons() {
        return jpaStreamer.stream(PersonEntity.class).map(PersonEntity::toData).toList();
    }

    public Person getPersonById(String id) {
        return jpaStreamer.stream(PersonEntity.class).filter(PersonEntity$.id.in(id)).findAny()
                          .map(PersonEntity::toData).orElse(null);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person.toEntity()).toData();
    }

    public Person updatePerson(String id, Person person) {
        var personEntity = personRepository.findById(id).orElseThrow();
        updateAddressEntity(person, personEntity);

        return updatePersonEntity(person, personEntity);
    }

    private Person updatePersonEntity(Person person, PersonEntity personEntity) {
        personEntity.setEmail(person.getEmail());
        personEntity.setName(person.getName());
        personEntity.setPhone(person.getPhone());
        return personRepository.save(personEntity).toData();
    }

    private void updateAddressEntity(Person person, PersonEntity personEntity) {
        var addressEntity = personEntity.getAddress();
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setZip(person.getAddress().getZip());
        addressEntity.setStreet(person.getAddress().getStreet());
        addressEntity.setState(person.getAddress().getState());
        addressRepository.save(addressEntity);
    }

    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }
}
