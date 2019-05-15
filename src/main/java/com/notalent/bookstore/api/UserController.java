package com.notalent.bookstore.api;

import com.notalent.bookstore.jwt.JwtUtils;
import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.jwt.TokenValidation;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.service.UserService;
import com.notalent.bookstore.util.IntegerUtils;
import com.notalent.bookstore.util.Result;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 用户api
 * @author noTalent
 * @version 1.0
 * 2019.05.09
 */
@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @PostMapping("/v1/user/register")
    public Result register(UserInfo userInfo) {
        if (StringUtils.isBlank(userInfo.getUsername()) || StringUtils.isBlank(userInfo.getPassword())) {
            return Result.error();
        }
        Integer res = userService.register(userInfo);
        if (IntegerUtils.isError(res)) {
            return Result.error();
        }
        return Result.success();
    }

    @GetMapping("/v1/user/login")
    @CrossTokenValidation
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response) {
        UserInfo ui = new UserInfo(username, password);
        Integer res = userService.login(ui);
        if (IntegerUtils.isNotError(res)) {
            ui.setUserInfoId(res);
            String token = JwtUtils.getToken(ui);
            // token 存入 redis
            redisTemplate.opsForValue().set(token, ui, JwtUtils.EXPIRES, TimeUnit.SECONDS);
            // token 存入 header
            response.addHeader("Token", token);
            return Result.success();
        }
        return Result.error();
    }

    @PostMapping("/v1/password/alter")
    @TokenValidation
    public Result alterPassword(@RequestParam("username") String username,
                                @RequestParam("password") String password) {
        if (StringUtils.isBlank(password)) {
            return Result.error();
        }
        UserInfo userInfo = new UserInfo(username, password);
        Integer res = userService.alterPassword(userInfo);
        if (IntegerUtils.isError(res)) {
            return Result.error();
        }
        return Result.success();
    }

}
