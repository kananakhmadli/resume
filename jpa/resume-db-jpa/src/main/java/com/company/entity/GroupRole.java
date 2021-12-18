package com.company.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
//@Table(name = "my_group_role")
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

    public GroupRole() {
    }

    public GroupRole(MyGroup myGroup, Role role) {
        this.myGroup = myGroup;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MyGroup getMyGroup() {
        return myGroup;
    }

    public void setMyGroup(MyGroup myGroup) {
        this.myGroup = myGroup;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupRole)) return false;
        GroupRole groupRole = (GroupRole) o;
        return getId().equals(groupRole.getId()) &&
                Objects.equals(getMyGroup(), groupRole.getMyGroup()) &&
                Objects.equals(getRole(), groupRole.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMyGroup(), getRole());
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
