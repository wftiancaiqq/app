package com.wf.first.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import com.wf.first.app.utils.RedisUtil;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {

    private UserService userService;

    private RedisUtil redisUtil;

//    @PostMapping("/login")
//    public BaseResult<String> login(@RequestBody User user) {
//        List<User> userList = userService.getBaseMapper().selectList(new QueryWrapper<User>()
//                .lambda()
//                .eq(User::getUserName, user.getUserName())
//                .eq(User::getPassword, user.getPassword()));
//        if (CollectionUtils.isEmpty(userList)) {
//            return BaseResult.fail("用户名或密码错误");
//        }
//
//        String uuid = UUID.randomUUID().toString();
//        redisUtil.set(uuid, uuid, 60*30);
//        return BaseResult.success(uuid);
//    }
//
//    @PostMapping("/testToken")
//    public BaseResult<Boolean> testToken(@RequestBody User user) {
//        return BaseResult.success();
//    }

    @PostMapping("/noAuth")
    public BaseResult<Boolean> noAuth(@RequestBody User user) {
        return BaseResult.noAuth();
    }
    //Collection
}
