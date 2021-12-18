package com.company;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        UserDaoInter userDao = Context.instanceUserDao();
//        List<User> users = userDao.getAll(null, null, null);
//        System.out.println(users.get(0));
//        for (User user : users) {
//            System.out.println(user);
//        }
        SkillDaoInter skillDao=Context.instanceSkillDao();
        List<Skill> skills=skillDao.getAll();
        System.out.println(skills);

    }

}
