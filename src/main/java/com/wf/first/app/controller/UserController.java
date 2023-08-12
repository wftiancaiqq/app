package com.wf.first.app.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.CommonService;
import com.wf.first.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public BaseResult<Boolean> register(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUserName())) {
            return BaseResult.fail("用户名不能为空");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return BaseResult.fail("密码不能为空");
        }
        if (StringUtils.isEmpty(user.getPhone())) {
            return BaseResult.fail("手机号不能为空");
        }
        if (StringUtils.isEmpty(user.getEmail())) {
            return BaseResult.fail("邮箱不能为空");
        }

        boolean result = userService.register(user);
        if (!result) {
            return BaseResult.fail("注册失败");
        }
        return BaseResult.success();
    }

    @GetMapping("/test")
    public BaseResult<Boolean> test() {
        return BaseResult.success();
    }
}
