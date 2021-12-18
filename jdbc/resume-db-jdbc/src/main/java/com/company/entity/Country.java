package com.company.entity;

import lombok.*;

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
