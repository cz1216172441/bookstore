package com.notalent.bookstore.service;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.shiro.ShiroUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("user1");
        userInfo.setPassword("123456");
        int res = userService.addUserInfo(userInfo);
        Assert.assertEquals(res, 1);
    }

    @Test
    public void login() {
        UserInfo ui = new UserInfo();
        ui.setUsername("user1");
        ui.setPassword("123456");
        Assert.assertEquals(true, userService.login(ui));
    }

    @Test
    public void StringUtilsTest() {
        String str = " 1 2 3";
        Assert.assertEquals("123", StringUtils.trim(str));
    }
}