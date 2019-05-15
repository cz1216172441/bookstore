package com.notalent.bookstore.service.impl;

import com.notalent.bookstore.mapper.ManagerMapper;
import com.notalent.bookstore.pojo.manager.*;
import com.notalent.bookstore.service.ManagerService;
import com.notalent.bookstore.shiro.ShiroUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 管理员服务处实现
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Integer addManager(Manager manager) {
        // 加盐加密
        String salt = ShiroUtils.getSalt();
        String pwd = ShiroUtils.encrypt(manager.getPassword(), salt);
        manager.setSalt(salt);
        manager.setPassword(pwd);
        // 设置时间
        manager.setCreateTime(new Date());
        manager.setUpdateTime(new Date());
        Integer res = managerMapper.addManager(manager);
        // 添加成功 => 返回自增主键
        if (res > 0) return manager.getManagerId();
        return res;
    }

    @Override
    public Manager findByUsername(String username) {
        return managerMapper.findByUsername(username);
    }

    @Override
    public String findSaltByUsername(String username) {
        return managerMapper.findSaltByUsername(username);
    }

    @Override
    public Manager findPasswordByUsername(String username) {
        return managerMapper.findPasswordByUsername(username);
    }

    @Override
    public Integer alterPassword(Manager manager) {
        // 获取新的随机盐值并加密新密码
        String salt = ShiroUtils.getSalt();
        String pwd = ShiroUtils.encrypt(manager.getPassword(), salt);
        manager.setSalt(salt);
        manager.setPassword(pwd);
        // 设置修改时间
        manager.setUpdateTime(new Date());
        return managerMapper.alterPassword(manager);
    }

    @Override
    public Integer addPermission(Permission permission) {
        permission.setCreateTime(new Date());
        Integer res = managerMapper.addPermission(permission);
        if (res > 0) return permission.getPermissionId();
        return res;
    }

    @Override
    public Integer addRole(Role role) {
        role.setCreateTime(new Date());
        Integer res = managerMapper.addRole(role);
        if (res > 0) return role.getRoleId();
        return res;
    }

    @Override
    public Integer addRolePerm(RolePermission rolePermission) {
        rolePermission.setCreateTime(new Date());
        return managerMapper.addRolePerm(rolePermission);
    }

    @Override
    public Integer addManagerRole(ManagerRole managerRole) {
        managerRole.setCreateTime(new Date());
        return managerMapper.addManagerRole(managerRole);
    }
}
