package com.renanpelicari.aoptalk.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.util.UUID;

@Data
@Builder
public class Person {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    UUID id;

    @Column(name = "NAME", nullable = false, length = 100)
    String name;

    @Column(name = "EMAIL", nullable = false, length = 100)
    String email;
}
