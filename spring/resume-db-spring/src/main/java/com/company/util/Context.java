package com.company.util;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EnpoymentHistoryDoaInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmpoymentHistoryDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;

public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EnpoymentHistoryDoaInter instanceEmploymentHistoryDao() {
        return new EmpoymentHistoryDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }

}