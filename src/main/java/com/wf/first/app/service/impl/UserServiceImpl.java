package com.wf.first.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.mapper.UserMapper;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //@Resource
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(Long id) {
        User user = userMapper.selectByUserId(id);

        return user;
    }

    @Override
    public List<User> list(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        List<User> result = userMapper.selectListByList(userDTO);
        return result;
    }
}
