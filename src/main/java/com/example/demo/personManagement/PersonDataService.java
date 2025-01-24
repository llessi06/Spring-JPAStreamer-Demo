package com.example.demo.personManagement;

import com.example.demo.personManagement.data.Person;
import com.example.demo.personManagement.rest.dto.PersonDto;
import com.example.demo.personManagement.rest.resource.PersonResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class PersonDataService {
    @Autowired
    private PersonManager personManager;

    public List<PersonResource> getAllPersons() {
        return personManager.getAllPersons().stream().map(Person::toResource).toList();
    }

    public PersonResource getPersonById(String id) {
        var person = personManager.getPersonById(id);
        return person != null ? person.toResource() : null;
    }

    public PersonResource createPerson(PersonDto personDto) {
        return personManager.createPerson(personDto.toData()).toResource();
    }

    public PersonResource updatePerson(String id, PersonDto personDto) {
        var person = personManager.updatePerson(id, personDto.toData());
        return person != null ? person.toResource() : null;
    }

    public void deletePerson(String id) {
        personManager.deletePerson(id);
    }

}
