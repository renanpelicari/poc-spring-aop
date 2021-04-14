package com.renanpelicari.aoptalk.entity.adapter;

import com.renanpelicari.aoptalk.entity.Person;
import com.renanpelicari.aoptalk.entity.vo.PersonResponseVo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class PersonAdapter {

    public static PersonResponseVo modelToVo(Person model) {
        return PersonResponseVo.builder()
                .name(model.getName())
                .email(model.getEmail())
                .build();
    }
}
