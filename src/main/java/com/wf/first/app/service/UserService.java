package com.wf.first.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> list(UserDTO userDTO);
}
