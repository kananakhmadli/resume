package com.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSkillDto {

    private Integer id;
    private Integer power;
    private SkillDto skill;

}