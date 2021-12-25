package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

public class Main {

    public static void main(String[] args) throws Exception {// 
        UserDaoInter userDao = Context.instanceUserDao();
//        List<User> userList=userDao.getAll(null,null,null);
//        out.println(userList.get(0));

        User u = userDao.findByEmailAndPassword("kanan.akhmadli99@gmail.com", "12345");

        System.out.println(u);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }

}