package com.wf.first.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wf.first.app.pojo.User;


public interface UserService extends IService<User> {
    /**
     * 注册
     */
    Boolean register(User user);
}
