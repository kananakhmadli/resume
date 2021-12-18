package com.company.dao.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDoaInter {

    public List<EmploymentHistory> getEmploymentHistoryByUserId(int userId);

}
