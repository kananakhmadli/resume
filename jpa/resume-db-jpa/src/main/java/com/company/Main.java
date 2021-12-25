package com.company;

import com.company.dao.inter.UserDaoInter;

public class Main {

    public static void main(String[] args) {

        UserDaoInter userDao = Context.instanceUserDao();
        userDao.getAll(null, null, null);

    }
}