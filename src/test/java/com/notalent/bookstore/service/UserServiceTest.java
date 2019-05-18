package com.notalent.bookstore.service;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.jwt.JwtUtils;
import com.notalent.bookstore.mapper.UserMapper;
import com.notalent.bookstore.pojo.user.UserDetail;
import com.notalent.bookstore.pojo.user.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void addUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user1");
        userInfo.setPassword("123456");
        int res = userService.register(userInfo);
        Assert.assertEquals(res, 1);
    }

    @Test
    public void login() {
        UserInfo ui = new UserInfo();
        ui.setUsername("user1");
        ui.setPassword("notalent");
        if (userService.login(ui) > 0) {
            stringRedisTemplate.opsForValue().set(ui.getUsername(), ui.getPassword());
        }
        System.err.println(stringRedisTemplate.opsForValue().get(ui.getUsername()));
        Assert.assertEquals(ui.getPassword(), stringRedisTemplate.opsForValue().get(ui.getUsername()));
    }

    @Test
    public void StringUtilsTest() {
        String str = " 1 2 3";
        Assert.assertEquals("123", StringUtils.trim(str));
    }

    @Test
    public void register() {
        UserInfo userInfo = new UserInfo("user1", "123456");
        Assert.assertEquals(new Integer(1), userService.register(userInfo));
    }

    @Test
    public void alterPassword() {
        UserInfo ui = new UserInfo();
        ui.setUsername("user1");
        ui.setPassword("123456");
        int res = userService.updatePassword(ui);
        Assert.assertEquals(1, res);
    }

    @Test
    public void jwtTest() throws Exception {
        UserInfo ui = new UserInfo("user1", "123456");
        ui.setUserInfoId(1);
//        String token = JwtUtils.getToken(ui);
        // 19:30
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhdXRoMCIsImV4cCI6MTU1ODE4Mjc4NSwidXNlciI6MX0.mPOBb7Rniym2V3cGBlhPAQZqlVQsV4LKP4PJzEPSAn0";
//        redisTemplate.opsForValue().set(token, ui, 60 * 1000, TimeUnit.SECONDS);
//        System.err.println(token);
        System.out.println(JwtUtils.getUserInfoId(token));
        System.out.println(((UserInfo)redisTemplate.opsForValue().get(token)).toString());
        Assert.assertEquals(true, JwtUtils.verify((UserInfo)redisTemplate.opsForValue().get(token), token));
    }

    @Test
    public void getUserAllInfo() {
        Integer userInfoId = 1;
        UserInfo ui = userService.getUserAllInfo(userInfoId);
        System.out.println(ui.toString());
    }

    @Test
    public void updateUserDetail() {
        UserDetail ud = new UserDetail();
        ud.setUserInfoId(1);
        ud.setUserNickname("nick1");
        ud.setUserGender("男");
        ud.setUserBirthday(new Date());
        int res = userService.updateUserDetail(ud);
        Assert.assertEquals(1, res);
    }


}