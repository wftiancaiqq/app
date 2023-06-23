package com.wf.first.app.config;

import com.wf.first.app.utils.RedisUtil;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@AllArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(redisUtil.hasKey(token)){
            redisUtil.expire(token, 30*60);
            return true;
        }

        request.getRequestDispatcher("/auth/noAuth").forward(request,response);
//       重定向是两次请求，request生命周期会结束，获取不到msg     response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }

}
