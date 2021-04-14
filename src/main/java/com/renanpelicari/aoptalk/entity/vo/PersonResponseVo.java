package com.renanpelicari.aoptalk.entity.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponseVo {

    String name;

    String email;
}
