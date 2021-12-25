package com.company.service.inter;

import com.company.entity.User;

import java.util.List;

public interface UserServiceInter {

    List<User> getAll(String name, String surname, Integer nationalityId);

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User getById(int id);

    boolean updateUser(User u);

    boolean addUser(User u);

    boolean removeUser(int id);

}