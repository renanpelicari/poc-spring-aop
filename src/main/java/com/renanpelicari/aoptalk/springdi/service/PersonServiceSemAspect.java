package com.renanpelicari.aoptalk.springdi.service;

import com.renanpelicari.aoptalk.aop.annotation.LogMethodExecution;
import com.renanpelicari.aoptalk.entity.Person;
import com.renanpelicari.aoptalk.entity.adapter.PersonAdapter;
import com.renanpelicari.aoptalk.entity.vo.PersonResponseVo;
import com.renanpelicari.aoptalk.springdi.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonServiceSemAspect {

    private final PersonRepository personRepository;

    public PersonServiceSemAspect(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonResponseVo getByEmail(String email) {
        log.info("BEGIN getByEmail, args={}", email);
        Person model = personRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Person not found by email [" + email + "]"));

        PersonResponseVo response = PersonAdapter.modelToVo(model);
        log.info("END getByEmail, response={}", response);
        return response;
    }
}
