package com.wf.first.app.controller;

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

    @GetMapping("/getUserById")
    public BaseResult<User> getUserById(Long id) {
        User user = userService.getUserById(id);
        userService.list(new UserDTO());
        return BaseResult.success(user);
    }
}
