package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;

public interface EnpoymentHistoryDoaInter {

    public List<EmploymentHistory> getEmploymentHistoryByUserId(int userId);

}
