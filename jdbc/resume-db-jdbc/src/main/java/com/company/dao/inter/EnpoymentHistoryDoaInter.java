/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author Kanan
 */
public interface EnpoymentHistoryDoaInter {

    public List<EmploymentHistory> getEmploymentHistoryByUserId(int userId);

}
