package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private String address;

    @Lob
    private String profileDesc;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    @ManyToOne()
    private Country nationality;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserSkill> userSkills;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<EmploymentHistory> employmentHistories;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.EAGER)
    private List<GroupUser>groupUsers;

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String surname, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", profileDesc='" + profileDesc + '\'' +
                ", nationality=" + nationality +
                '}';
    }

}