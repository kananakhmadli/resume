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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String header;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Lob
    private String jobDescription;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public EmploymentHistory(Integer id) {
        this.id = id;
    }

    public EmploymentHistory(Integer id, String header, Date beginDate, String jobDescription) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.jobDescription = jobDescription;
    }

    public EmploymentHistory(Integer id, String header, java.sql.Date beginDate, java.sql.Date endDate,
                             String jobDescription, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.user = user;
    }

    @Override
    public String toString() {
        return "com.company.entity.EmploymentHistory[ id=" + id + " ]";
    }

}