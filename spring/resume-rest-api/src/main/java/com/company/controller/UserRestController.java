package com.company.controller;


import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserServiceInter userServiceInter;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surname", required = false) String surname

    ) {

        List<User> users = userServiceInter.getAll(name, surname, null);

        List<UserDTO> userDTOS = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }

        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id) {
        User user = userServiceInter.getById(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) {
        User user = userServiceInter.getById(id);
        userServiceInter.removeUser(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Successfully deleted"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPlainPassword());
        user.setProfileDesc(userDto.getPlainPassword());
        userServiceInter.addUser(user);

        return ResponseEntity.ok(ResponseDTO.of(userDto, "Successfully added"));

    }

}