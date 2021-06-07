package com.liveinpast.commnitymvc.service;

import com.liveinpast.commnitymvc.dao.UserMapper;
import com.liveinpast.commnitymvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
