package com.wf.first.app.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.dto.UserDTO;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {

    private UserService userService;

//    private RedisUtil redisUtil;

    @PostMapping("/login")
    public BaseResult<UserDTO> login(@RequestBody User user) {
        List<User> userList = userService.getBaseMapper().selectList(new QueryWrapper<User>()
                .lambda()
                .eq(User::getUserName, user.getUserName())
                .eq(User::getPassword, user.getPassword()));
        if (CollectionUtils.isEmpty(userList)) {
            return BaseResult.fail("用户名或密码错误");
        }

        User loginUser = userList.get(0);
        UserDTO result = new UserDTO();
        result.setId(loginUser.getId());
        result.setUserName(loginUser.getUserName());
        result.setPassword(loginUser.getPassword());
        result.setDefaultX(true);
        result.setRoleState(true);
        result.setRoleId(1);
        result.setRegion("中国");
        UserDTO.RoleDTO roleDTO = new UserDTO.RoleDTO();
        roleDTO.setId(1);
        roleDTO.setRoleName("超级管理员");
        roleDTO.setRoleType(1);
        List<String> rights = JSONArray.parseArray(" [\n" +
                "        \"/user-manage/add\",\n" +
                "        \"/user-manage/delete\",\n" +
                "        \"/user-manage/update\",\n" +
                "        \"/user-manage/list\",\n" +
                "        \"/right-manage/role/list\",\n" +
                "        \"/right-manage/right/list\",\n" +
                "        \"/right-manage/role/update\",\n" +
                "        \"/right-manage/role/delete\",\n" +
                "        \"/right-manage/right/update\",\n" +
                "        \"/right-manage/right/delete\",\n" +
                "        \"/news-manage\",\n" +
                "        \"/news-manage/list\",\n" +
                "        \"/news-manage/add\",\n" +
                "        \"/news-manage/update/:id\",\n" +
                "        \"/news-manage/preview/:id\",\n" +
                "        \"/news-manage/draft\",\n" +
                "        \"/news-manage/category\",\n" +
                "        \"/audit-manage\",\n" +
                "        \"/audit-manage/audit\",\n" +
                "        \"/audit-manage/list\",\n" +
                "        \"/publish-manage\",\n" +
                "        \"/publish-manage/unpublished\",\n" +
                "        \"/publish-manage/published\",\n" +
                "        \"/publish-manage/sunset\",\n" +
                "        \"/home\",\n" +
                "        \"/user-manage\",\n" +
                "        \"/right-manage\"\n" +
                "      ]", String.class);
        roleDTO.setRights(rights);
        result.setRole(roleDTO);
        return BaseResult.success(result);
    }
    @PostMapping("/noAuth")
    public BaseResult<String> noAuth(HttpServletRequest request, HttpServletResponse response) {
        return BaseResult.noAuth();
    }

    @PostMapping("/testToken")
    public BaseResult<Boolean> testToken(@RequestBody User user) {
        return BaseResult.success();
    }

}
