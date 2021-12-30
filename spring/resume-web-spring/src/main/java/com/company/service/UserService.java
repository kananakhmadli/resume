package com.company.service;

import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.repository.UserRepositoryCustom;
import com.company.security.DummyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SuppressWarnings("unused")
@Slf4j
@Transactional
@Service
public class UserService {

    private final UserRepositoryCustom userRepositoryCustom;
    private final DummyService dummyService;

    public UserService(UserRepositoryCustom userRepositoryCustom, DummyService dummyService) {
        this.userRepositoryCustom = userRepositoryCustom;
        this.dummyService = dummyService;
    }

    public ModelAndView getAllUser1(String name, String surname, String email) {
        List<User> list = userRepositoryCustom.getAll(name, surname, email);
        ModelAndView view = new ModelAndView("usersJ");
        view.addObject("list", list);
        try {
            dummyService.foo();
        } catch (Exception e) {
            log.info("Not Login as admin ");
        }
        return view;

    }

    public ModelAndView getAllUserM(UserDto userDto, BindingResult bindingResult) {
        List<User> list;
        ModelAndView view = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            list = userRepositoryCustom.getAll(null, null, null);
        } else
            list = userRepositoryCustom.getAll(userDto.getName(), userDto.getSurname(), userDto.getEmail());
        view.addObject("list", list);
        return view;
    }

    public void updateUser(User u) {
        userRepositoryCustom.updateUser(u);
    }

    public void removeUser(int id) {
        userRepositoryCustom.removeUser(id);
    }

    public User getById(int userId) {
        return userRepositoryCustom.getById(userId);
    }

    public void addUser(User u) {
        userRepositoryCustom.addUser(u);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepositoryCustom.findByEmailAndPassword(email, password);
    }

    public User findByEmail(String email) {
        return userRepositoryCustom.findByEmail(email);
    }

}