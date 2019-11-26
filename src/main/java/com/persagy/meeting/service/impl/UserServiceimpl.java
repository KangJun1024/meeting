package com.persagy.meeting.service.impl;

import com.persagy.meeting.entity.User;
import com.persagy.meeting.mapper.UserMapper;
import com.persagy.meeting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}