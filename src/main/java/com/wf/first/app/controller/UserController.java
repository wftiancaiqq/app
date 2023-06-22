package com.wf.first.app.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/queryUserList")
    public BaseResult<PageInfo<User>> queryUserList() {
        PageHelper.startPage(1, 10, "id desc");
        List<User> userList = userService.list();
        PageInfo<User> pageInfo = new PageInfo<>(userList, 10);
        return BaseResult.success(pageInfo);
    }

    @PostMapping("/addUser")
    public BaseResult<Boolean> addUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return BaseResult.success(Boolean.TRUE);
    }
}
