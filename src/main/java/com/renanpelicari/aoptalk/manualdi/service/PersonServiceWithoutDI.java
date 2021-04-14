package com.renanpelicari.aoptalk.manualdi.service;

import com.renanpelicari.aoptalk.entity.Person;
import com.renanpelicari.aoptalk.entity.adapter.PersonAdapter;
import com.renanpelicari.aoptalk.entity.vo.PersonResponseVo;
import com.renanpelicari.aoptalk.manualdi.repository.PersonRepositoryWithoutDI;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceWithoutDI {

    private final PersonRepositoryWithoutDI repository;

    public PersonServiceWithoutDI() {
        this.repository = new PersonRepositoryWithoutDI();
    }

    public PersonResponseVo getByEmail(String email) {
        Person model = repository.findByEmail(email);
        return PersonAdapter.modelToVo(model);
    }
}
