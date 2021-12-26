package com.company.controller;

import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.security.DummyService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;
    private final DummyService dummyService;

    public UserController(UserService userService, DummyService dummyService) {
        this.userService = userService;
        this.dummyService = dummyService;
    }

   /* @RequestMapping(method = RequestMethod.GET, value = "/users1")
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        List<User> list = userServiceInter.getAll(name, surname, null);
        request.setAttribute("list", list);
        return "usersJ";
    }*/

    @GetMapping(value = {"/users1", "/users2"})
    public ModelAndView index(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname) {

        List<User> list = userService.getAll(name, surname, null);
        ModelAndView view = new ModelAndView("usersJ");
        view.addObject("list", list);
        return view;
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/users3")
    public ModelAndView index3(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname) {

        List<User> list = userServiceInter.getAll(name, surname, null);
        ModelAndView view = new ModelAndView("users");
        view.addObject("list", list);
        return view;
    }*/

    @GetMapping(value = "/usersm")
    public ModelAndView index4(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        List<User> list = null;
        ModelAndView view = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            list = userService.getAll(null, null, null);
        } else
            list = userService.getAll(userDto.getName(), userDto.getSurname(), null);
        view.addObject("list", list);
        return view;
    }

    @GetMapping(value = "/kanan")
    public String index5() {
        log.info("kanan controller was called");
        try {
            dummyService.foo();
        } catch (Exception e) {
            log.info("Admin kimi girmədiyinə görə error");
        }
        return "kanan";
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/logout")
    public String logout() {
        return "logout";
    }

    @ModelAttribute("user")
    public UserDto getEmptyForm() {
        return new UserDto();
    }

}