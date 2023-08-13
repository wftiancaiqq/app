package com.wf.first.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.wf.first.app.common.PageResult;
import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.dto.UserQueryDTO;
import com.wf.first.app.pojo.User;
import com.wf.first.app.vo.UserVO;


public interface UserService extends IService<User> {
    /**
     * 注册
     */
    Boolean register(User user);

    /**
     * 查询用户列表
     */
    PageResult<UserVO> listUser(UserQueryDTO queryDTO);
}
