package com.example.demo.personManagement.database.repository;

import com.example.demo.personManagement.database.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, String> {
}
