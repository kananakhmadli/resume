package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Country {

    private int id;
    private String name;
    private String nationality;

    @Override
    public String toString() {
        return name + "(" + nationality + ")";
    }

}