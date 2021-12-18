package com.company;

import com.company.dao.impl.SkillDaoImpl;
import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.impl.UserDaoImpl;

public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }
//
    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }
//
//    public static EnpoymentHistoryDoaInter instancEnpoymentHistoryDao() {
//        return new EmpoymentHistoryDaoImpl();
//    }
//
//    public static CountryDaoInter instancCountryDao() {
//        return new CountryDaoImpl();
//    }

}
