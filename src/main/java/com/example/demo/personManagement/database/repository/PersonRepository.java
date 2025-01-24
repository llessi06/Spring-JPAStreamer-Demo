package com.example.demo.personManagement.database.repository;

import com.example.demo.personManagement.database.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, String> {
}
