package com.company.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {
    @Size(min = 3, message = "not less than 3")
    private String name;
    @NotEmpty
    private String surname;

    public UserForm() {
    }

    public UserForm(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

}
