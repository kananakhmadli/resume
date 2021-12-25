package com.company.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EmploymentHistory {

    private Integer id;
    private String header;
    private String jobDescription;
    private Date beginDate;
    private Date endDate;
    private User user;

    @Override
    public String toString() {
        return "EmploymentHistory{" + "id=" + id + ", header=" + header + ", jobDescription=" + jobDescription + ", beginDate=" + beginDate + ", endDate=" + endDate + ", user=" + user + '}';
    }
}