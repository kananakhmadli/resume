package com.company.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class MyGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "myGroup")
    private List<GroupRole>groupRoles;

    public MyGroup() {
    }

    public MyGroup(String name) {
        this.name = name;
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

    public List<GroupRole> getGroupRoles() {
        return groupRoles;
    }

    public void setGroupRoles(List<GroupRole> groupRoles) {
        this.groupRoles = groupRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyGroup)) return false;
        MyGroup myGroup = (MyGroup) o;
        return getId().equals(myGroup.getId()) &&
                Objects.equals(getName(), myGroup.getName()) &&
                Objects.equals(getGroupRoles(), myGroup.getGroupRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGroupRoles());
    }

    @Override
    public String toString() {
        return "MyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

