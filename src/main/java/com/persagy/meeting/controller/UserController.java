package com.persagy.meeting.controller;

import com.persagy.meeting.entity.TUser;
import com.persagy.meeting.entity.User;
import com.persagy.meeting.service.TUserService;
import com.persagy.meeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TUserService tUserService;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/List")
    public List<TUser> List() throws Exception{
        return tUserService.findAll();
    }

    @GetMapping("/insert")
    public String insert() throws Exception{
        TUser user = new TUser();
        return tUserService.addUser(user);
    }



}