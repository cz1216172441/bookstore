package com.notalent.bookstore.api;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.notalent.bookstore.jwt.JwtUtils;
import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.jwt.TokenValidation;
import com.notalent.bookstore.pojo.user.UserDetail;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.service.UserService;
import com.notalent.bookstore.util.UserUtils;
import com.notalent.bookstore.util.IntegerUtils;
import com.notalent.bookstore.util.Result;

import com.notalent.bookstore.vo.UserVO;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    /**
     * 用户注册
     * @param userInfo 用户信息
     * @return result
     */
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

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密  码
     * @param response 响  应
     * @return result
     */
    @GetMapping("/v1/user/login")
    @CrossTokenValidation
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletResponse response) throws JWTDecodeException {
        UserInfo ui = new UserInfo(username, password);
        Integer res = userService.login(ui);
        if (IntegerUtils.isNotError(res)) {
            ui.setUserInfoId(res);
            String token = JwtUtils.getToken(ui);
            // token 存入 redis
            redisTemplate.opsForValue().set(token, ui, JwtUtils.EXPIRES, TimeUnit.SECONDS);
            // token 存入 header
            response.addHeader("Token", token);
            // token过期时间 存入 header
            response.addHeader("Expires", JwtUtils.getExpires(token).toString());
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 修改用户密码
     * @param password 密  码
     * @return result
     */
    @PostMapping("/v1/password/update")
    @TokenValidation
    public Result updatePassword(@RequestParam("password") String password,
                                 HttpServletRequest request) throws JWTDecodeException {
        if (StringUtils.isBlank(password)) {
            return Result.error();
        }
        // 从token中获取用户信息id
        String token = request.getHeader("Token");
        Integer userInfoId = JwtUtils.getUserInfoId(token);
        if (IntegerUtils.isNotEmpty(userInfoId)) {
            UserInfo userInfo = new UserInfo(userInfoId, password);
            Integer res = userService.updatePassword(userInfo);
            if (IntegerUtils.isError(res)) {
                return Result.error();
            }
            // 删除token
            redisTemplate.delete(token);
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 注销
     * @param request 请  求
     * @return result
     */
    @GetMapping("/v1/user/logout")
    @TokenValidation
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader("Token");
        if (BooleanUtils.isTrue(redisTemplate.delete(token))) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 获取用户所有信息
     * @return result
     */
    @GetMapping("/v1/user/info")
    @TokenValidation
    public Result getUserAllInfo(HttpServletRequest request) throws JWTDecodeException {
        Integer userInfoId = JwtUtils.getUserInfoId(request);
        if (IntegerUtils.isNotEmpty(userInfoId)) {
            UserInfo ui = userService.getUserAllInfo(userInfoId);
            if (ui != null) {
                return Result.success(new UserVO(ui));
            }
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 修改用户详情信息
     * @param userDetail 用户详情
     * @param request 请 求
     * @return result
     * @throws JWTDecodeException
     */
    @PostMapping("/v1/userDetail/update")
    @TokenValidation
    public Result updateUserDetail(UserDetail userDetail,
                                   HttpServletRequest request) throws JWTDecodeException {
        if (userDetail != null) {
            userDetail.setUserInfoId(JwtUtils.getUserInfoId(request));
            // 性别是否合法
            String gender = userDetail.getUserGender();
            if (StringUtils.isNotEmpty(gender) && UserUtils.isGenderError(gender)) {
                return Result.error();
            }
            if (StringUtils.isEmpty(userDetail.getUserNickname()) &&
                StringUtils.isEmpty(userDetail.getUserGender()) &&
                userDetail.getUserBirthday() == null) {
                return Result.error();
            }
            Integer res = userService.updateUserDetail(userDetail);
            if (IntegerUtils.isNotError(res)) {
                return Result.success();
            }
        }
        return Result.error();
    }

    /**
     * 修改手机号码/电子邮箱
     * @param userInfo 用户信息
     * @param request 请  求
     * @return result
     * @throws JWTDecodeException
     */
    @PostMapping("/v1/userInfo/update")
    @TokenValidation
    public Result updateUserInfo(UserInfo userInfo,
                                 HttpServletRequest request) throws JWTDecodeException {
        if (userInfo != null) {
            userInfo.setUserInfoId(JwtUtils.getUserInfoId(request));
            // 电话号码和电子邮箱是否规范
            String phone = userInfo.getUserPhone();
            String email = userInfo.getUserEmail();
            if (StringUtils.isNotEmpty(phone) && UserUtils.isPhoneError(phone)) {
                return Result.error();
            }
            if (StringUtils.isNotEmpty(email) && UserUtils.isEmailError(email)) {
                return Result.error();
            }
            if (StringUtils.isEmpty(phone) && StringUtils.isEmpty(email)) {
                return Result.error();
            }
            Integer res = userService.updateUserInfo(userInfo);
            if (IntegerUtils.isNotError(res)) {
                return Result.success();
            }
        }
        return Result.error();
    }

    /**
     * 头像上传
     * @param file 头像
     * @param request 请 求
     * @return result
     */
    @PostMapping("/v1/headPortrait/upload")
    @TokenValidation
    public Result uploadHeadPortrait(@RequestParam("file") MultipartFile file,
                                     HttpServletRequest request) throws IOException {
        System.err.println(file);
        Integer userInfoId = JwtUtils.getUserInfoId(request);
        if (IntegerUtils.isNotError(userService.uploadHeadPortrait(file, userInfoId))) {
            return Result.success();
        }
        return Result.error();
    }

}
