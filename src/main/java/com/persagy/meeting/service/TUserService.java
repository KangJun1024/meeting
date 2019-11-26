package com.persagy.meeting.service;

import com.persagy.meeting.entity.TUser;

import java.util.List;

public interface TUserService {

    public List<TUser> findAll();

    String addUser(TUser user) throws Exception;
}
