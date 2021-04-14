package com.renanpelicari.aoptalk.springdi.repository;

import com.renanpelicari.aoptalk.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {

    Optional<Person> findByEmail(String email);
}
