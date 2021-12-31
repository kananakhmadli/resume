package com.company.controller;

import com.company.dto.ResponseDto;
import com.company.dto.UserDto;
import com.company.service.UserServiceRest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserServiceRest userServiceRest;

    public UserController(UserServiceRest userServiceRest) {
        this.userServiceRest = userServiceRest;
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDto> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname) {
        return ResponseEntity.ok().body(ResponseDto.of(userServiceRest.getUsers(name, surname)));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ResponseDto.of(userServiceRest.getUser(id)));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Integer id) {
        userServiceRest.removeUser(id);
        return ResponseEntity.ok(ResponseDto.of("Successfully deleted"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDto> addUser(@RequestBody UserDto userDto) {
        userServiceRest.addUser(userDto);
        return ResponseEntity.ok(ResponseDto.of("Successfully added"));
    }

}