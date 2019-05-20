package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.manager.*;

/**
 * 管理员服务层
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
public interface ManagerService {

    Integer addManager(Manager manager);             // 添加管理员

    Manager findByUsername(String username);         // 查询管理员

    String findSaltByUsername(String username);      // 查询盐值

    Manager findPasswordByUsername(String username); // 获取盐值和密码

    Integer alterPassword(Manager manager);          // 修改管理员密码

    Integer addPermission(Permission permission);    // 添加权限

    Integer addRole(Role role);                      // 添加角色

    Integer addRolePerm(RolePermission rolePermission);     // 添加角色权限

    Integer addManagerRole(ManagerRole managerRole);        // 添加管理员角色

}
