package com.renanpelicari.aoptalk.springdi.service;

import com.renanpelicari.aoptalk.entity.Person;
import com.renanpelicari.aoptalk.entity.adapter.PersonAdapter;
import com.renanpelicari.aoptalk.entity.vo.PersonResponseVo;
import com.renanpelicari.aoptalk.springdi.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonResponseVo getByEmail(String email) {
        Person model = personRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Person not found by email [" + email + "]"));

        return PersonAdapter.modelToVo(model);
    }
}
