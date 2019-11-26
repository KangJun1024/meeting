package com.persagy.meeting.service.impl;

import com.persagy.meeting.entity.TUser;
import com.persagy.meeting.entity.TUserExample;
import com.persagy.meeting.entity.User;
import com.persagy.meeting.mapper.TUserMapper;
import com.persagy.meeting.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service("tuserService")
public class TUserServiceimpl implements TUserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public List<TUser> findAll() {
        TUserExample example = new TUserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public String addUser(TUser user) throws Exception{
        String userId = UUID.randomUUID().toString();
        user.setcUserId(userId);
        Random random = new Random();
        user.setcUserName("kangjun" + random.nextInt());
        user.setcPassword("123456");
        user.setcType("1");
        user.setcCreateTime(new Date());
        user.setcUpdateTime(new Date());
        user.setcState("1");
        user.setcIsAdmin("1");


        int userSave = userMapper.insert(user);
        if (userSave != 1) {
            throw new Exception("添加用户失败");
        }
        return userId;
    }
}