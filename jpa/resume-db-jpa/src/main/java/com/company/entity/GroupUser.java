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
//@Table(name = "my_group_user")
public class GroupUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MyGroup myGroup;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public GroupUser() {
    }

    public GroupUser(MyGroup myGroup, User user) {
        this.myGroup = myGroup;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupUser)) return false;
        GroupUser groupUser = (GroupUser) o;
        return getId().equals(groupUser.getId()) &&
                getMyGroup().equals(groupUser.getMyGroup()) &&
                getUser().equals(groupUser.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMyGroup(), getUser());
    }

    @Override
    public String toString() {
        return "GroupUser{" +
                "id=" + id +
                '}';
    }
}
