package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GroupRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "my_groups_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MyGroup myGroup;

    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Role role;

    public GroupRole(MyGroup myGroup, Role role) {
        this.myGroup = myGroup;
        this.role = role;
    }

    @Override
    public String toString() {
        return "GroupRole{" +
                "id=" + id +
                ", role=" + myGroup +
                ", privilege=" + role +
                '}';
    }

}