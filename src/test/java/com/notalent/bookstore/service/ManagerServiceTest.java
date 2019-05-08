package com.notalent.bookstore.service;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.pojo.manager.Manager;
import com.notalent.bookstore.pojo.manager.Permission;
import com.notalent.bookstore.pojo.manager.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    @Test
    public void addManager() {
        Manager manager = new Manager();
        manager.setUsername("visitor");
        manager.setPassword("123456");
        System.out.println(managerService.addManager(manager));
    }

    @Test
    public void findSaltByUsername() {
        String username = "visitor";
        System.out.println(managerService.findSaltByUsername(username));
    }

    @Test
    public void alterPassword() {
        Manager manager = new Manager();
        manager.setUsername("visitor");
        manager.setPassword("visitor");
        long res = (long)managerService.alterPassword(manager);
        Assert.assertEquals(1, res);
    }

    @Test
    public void findPasswordByUsername() {
        Manager manager = managerService.findPasswordByUsername("visitor");
        Assert.assertEquals("f53cea1080a9b3b5594af0030965d8db", manager.getPassword());
        Assert.assertEquals("bfdbdc8092e0478e8346700e83451415", manager.getSalt());
    }

    @Test
    public void addRole() {
        Role role = new Role();
        role.setCreateTime(new Date());
        role.setRoleName("visit");
        managerService.addRole(role);
    }

    @Test
    public void addPermission() {
        Permission permission = new Permission();
        permission.setCreateTime(new Date());
        permission.setPermissionName("admin");
    }

}