package com.company.service;

import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.mapper.UserMapper;
import com.company.service.inter.UserServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceRest {

    private final UserServiceInter userServiceInter;
    private final UserMapper userMapper;

    public UserServiceRest(UserServiceInter userServiceInter, UserMapper userMapper) {
        this.userServiceInter = userServiceInter;
        this.userMapper = userMapper;
    }

    public List<UserDto> getUsers(String name, String surname) {
        List<User> users = userServiceInter.getAll(name, surname, null);
        return userMapper.toUserDtoList(users);
    }

    public UserDto getUser(Integer id) {
        User user = userServiceInter.getById(id);
        return userMapper.toUserDto(user);
    }

    public void removeUser(Integer id) {
        userServiceInter.removeUser(id);
    }

    public void addUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        userServiceInter.addUser(user);
    }

}