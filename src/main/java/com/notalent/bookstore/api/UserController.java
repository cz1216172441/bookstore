package com.notalent.bookstore.api;

import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.service.UserService;
import com.notalent.bookstore.util.IntegerUtil;
import com.notalent.bookstore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/v1/user/register")
    public Result register(UserInfo userInfo) {
        Integer res = userService.addUserInfo(userInfo);
        if (IntegerUtil.isError(res)) {
            return Result.error();
        }
        return Result.success();
    }

    @GetMapping("/v1/user/login")
    public Result login(UserInfo userInfo) {
        if (userService.login(userInfo)) {
            return Result.success();
        }
        return Result.error();
    }

}
