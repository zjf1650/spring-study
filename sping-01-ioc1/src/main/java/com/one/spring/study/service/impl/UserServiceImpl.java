package com.one.spring.study.service.impl;

import com.one.spring.study.dao.api.UserDao;
import com.one.spring.study.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    //@Autowired
    @Resource
    private UserDao userDao;
}
