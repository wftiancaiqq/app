package com.wf.first.app.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.Page;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.common.PageResult;
import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.dto.UserQueryDTO;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.CommonService;
import com.wf.first.app.service.UserService;
import com.wf.first.app.vo.UserVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


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

    @PostMapping("/list")
    public BaseResult<PageResult<UserVO>> list(@RequestBody UserQueryDTO queryDTO) {
        if (Objects.isNull(queryDTO.getPage())) {
            queryDTO.setPage(1);
        }
        if (Objects.isNull(queryDTO.getPageSize())) {
            queryDTO.setPageSize(10);
        }
        PageResult<UserVO> pageResult = userService.listUser(queryDTO);
        return BaseResult.success(pageResult);
    }


    @GetMapping("/test")
    public BaseResult<Boolean> test() {
        return BaseResult.success();
    }
}
