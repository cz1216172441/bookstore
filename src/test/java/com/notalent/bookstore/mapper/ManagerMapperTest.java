package com.notalent.bookstore.mapper;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.pojo.manager.Manager;
import com.notalent.bookstore.shiro.ShiroUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class ManagerMapperTest {

    @Resource
    private ManagerMapper managerMapper;

    @Test
    public void addManager() {
        // 获取盐值
        String salt = ShiroUtil.getSalt();
        // 加密
        String pwd = ShiroUtil.encrypt("123456", salt);

        Manager manager = new Manager();
        manager.setUsername("visitor1");
        System.out.println(manager.getManagerId());
    }

}