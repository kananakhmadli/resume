package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws Exception {// 
        UserDaoInter userDao = Context.instanceUserDao();
//        List<User> userList=userDao.getAll(null,null,null);
//        out.println(userList.get(0));

        User u=userDao.findByEmailAndPassword("kanan.akhmadli99@gmail.com","12345");
        out.println(u);
        out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }

}