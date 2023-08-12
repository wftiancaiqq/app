package com.wf.first.app.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public Boolean register(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUserName())) {
            return false;
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return false;
        }
        if (StringUtils.isEmpty(user.getPhone())) {
            return false;
        }
        if (StringUtils.isEmpty(user.getEmail())) {
            return false;
        }

        return userService.register(user);
    }
}
