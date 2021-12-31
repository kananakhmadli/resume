package com.company.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String plainPassword;
    private List<UserSkillDto> userSkills;

}
