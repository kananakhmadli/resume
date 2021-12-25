package com.company.dao.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDoaInter {

    List<EmploymentHistory> getEmploymentHistoryByUserId(int userId);

}