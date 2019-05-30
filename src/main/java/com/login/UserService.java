package com.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User verifyLogin(String userName, String password) {
        return userMapper.verifyLogin(userName,password);
    }

}
