package com.wf.first.app.config;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.first.app.common.BaseResult;
import com.wf.first.app.pojo.User;
import com.wf.first.app.service.UserService;
import com.wf.first.app.utils.RedisUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.List;
import java.util.Objects;

@Configuration
@AllArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            request.getRequestDispatcher("/auth/noAuth").forward(request,response);
            return false;
        }
        token = URLDecoder.decode(token, "UTF-8");
        User user = JSON.parseObject(token, User.class);
        if (Objects.isNull(user)) {
            request.getRequestDispatcher("/auth/noAuth").forward(request,response);
            return false;
        }
        List<User> userList = userService.getBaseMapper().selectList(new QueryWrapper<User>()
                .lambda()
                .eq(User::getUserName, user.getUserName())
                .eq(User::getPassword, user.getPassword()));
        if (CollectionUtils.isEmpty(userList)) {
            request.getRequestDispatcher("/auth/noAuth").forward(request,response);
            return false;
        }

        return true;
    }

}
