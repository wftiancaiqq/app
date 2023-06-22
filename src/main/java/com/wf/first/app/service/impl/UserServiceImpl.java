package com.wf.first.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.first.app.mapper.UserMapper;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
