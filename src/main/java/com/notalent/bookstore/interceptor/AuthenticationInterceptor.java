package com.notalent.bookstore.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.jwt.JwtUtils;
import com.notalent.bookstore.jwt.TokenValidation;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 身份验证拦截器
 * @author noTalent
 * @version 1.0
 * 2019.05.16
 */
@CrossOrigin("*")
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Token");
        // response -> json
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        // 如果不是映射到方法直接通过验证
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        // 检测是否有通过token验证的注解
        if (method.isAnnotationPresent(CrossTokenValidation.class)) {
            CrossTokenValidation crossTokenValidation = method.getAnnotation(CrossTokenValidation.class);
            if (crossTokenValidation.required()) {
                return true;
            }
        }
        // 检测是否有需要token验证的注解
        if (method.isAnnotationPresent(TokenValidation.class)) {
            TokenValidation tokenValidation = method.getAnnotation(TokenValidation.class);
            if (tokenValidation.required()) {
                // token验证
                if (StringUtils.isEmpty(token)) {
                    writer = response.getWriter();
                    writer.print(Result.errorJson());
                    writer.close();
                    throw new RuntimeException("token不能为空，请重新登录");
                }
                UserInfo userInfo = (UserInfo)redisTemplate.opsForValue().get(token);
                if (userInfo == null) {
                    writer = response.getWriter();
                    writer.print(Result.errorJson());
                    writer.close();
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                try {
                    if (JwtUtils.verify(userInfo, token)) {
                        return true;
                    } else {
                        writer = response.getWriter();
                        writer.print(Result.errorJson());
                        writer.close();
                        return false;
                    }
                } catch (JWTVerificationException exception) {
                    throw new RuntimeException("401");
                }
            }
        }
        writer = response.getWriter();
        writer.print(Result.errorJson());
        writer.close();
        return false;
    }

}
