package com.company.dto;

import com.company.entity.User;
import com.company.entity.UserSkill;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String plainPassword;

    private List<UserSkillDTO> userSkills;


    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.plainPassword = user.getProfileDesc();
        List<UserSkill> userSkills = user.getUserSkills();

        List<UserSkillDTO> userSkillDTOS = new ArrayList<>();

        for (UserSkill userSkill : userSkills) {
            userSkillDTOS.add(new UserSkillDTO(userSkill));
        }

        this.userSkills = userSkillDTOS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public List<UserSkillDTO> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<UserSkillDTO> userSkills) {
        this.userSkills = userSkills;
    }
}
