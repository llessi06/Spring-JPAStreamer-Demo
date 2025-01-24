package com.example.demo.personManagement.rest;

import com.example.demo.personManagement.PersonDataService;
import com.example.demo.personManagement.rest.dto.PersonDto;
import com.example.demo.personManagement.rest.resource.PersonResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@CrossOrigin(originPatterns = "*")
@Validated
@RequestMapping(value = "/person", produces = "application/json")
public class PersonRestController {
    @Autowired
    private PersonDataService personDataService;

    @GetMapping
    public List<PersonResource> getAllPersons() {
        return personDataService.getAllPersons();
    }

    @GetMapping("/{id}")
    public PersonResource getPersonById(@PathVariable String id) {
        return personDataService.getPersonById(id);
    }


    @PostMapping
    public PersonResource createPerson(@RequestBody PersonDto personDto) {
        return personDataService.createPerson(personDto);
    }

    @PutMapping("/{id}")
    public PersonResource updatePerson(@PathVariable String id, @RequestBody PersonDto personDto) {
        return personDataService.updatePerson(id, personDto);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable String id) {
        personDataService.deletePerson(id);
    }
}
