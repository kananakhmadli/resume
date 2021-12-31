package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

public class Main {

    public static void main(String[] args) {
        UserDaoInter userDao = Context.instanceUserDao();
        User user = new User();
        user.setName("Kanan");
        user.setEmail("kanan.akhmadli99@gmail.com");
        user.setPhone("1121321");
        userDao.addUser(user);

        System.out.println(userDao.getAll(null, null, null));

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }

}