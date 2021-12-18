package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping({"/", "/hello"})
    public String index1(){
        return "hello";
    }


    @GetMapping("/index")
    public String index2(){
        return "index";
    }

}
