package com.company;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EnpoymentHistoryDoaInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.dao.impl.CountryDaoImpl;
import com.company.dao.impl.EmploymentHistoryDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.dao.impl.UserSkillDaoImpl;

public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instancUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EnpoymentHistoryDoaInter instancEnpoymentHistoryDao() {
        return new EmploymentHistoryDaoImpl();
    }

    public static CountryDaoInter instancCountryDao() {
        return new CountryDaoImpl();
    }

}
