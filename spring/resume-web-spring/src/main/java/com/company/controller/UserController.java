package com.company.controller;

import com.company.dto.UserDto;
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

@SuppressWarnings("CommentedOutCode")
@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/users1", "/users2"})
    public ModelAndView users1(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) String email) {
        return userService.getAllUser1(name, surname, email);
    }

    @GetMapping(value = "/usersm")
    public ModelAndView usersM(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult bindingResult) {
        return userService.getAllUserM(userDto, bindingResult);
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

   /*
   @RequestMapping(method = RequestMethod.GET, value = "/users1")
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        List<User> list = userServiceInter.getAll(name, surname, null);
        request.setAttribute("list", list);
        return "usersJ";
    }*/

    /*
    @RequestMapping(method = RequestMethod.GET, value = "/users3")
    public ModelAndView index3(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname) {

        List<User> list = userServiceInter.getAll(name, surname, null);
        ModelAndView view = new ModelAndView("users");
        view.addObject("list", list);
        return view;
    }*/

}