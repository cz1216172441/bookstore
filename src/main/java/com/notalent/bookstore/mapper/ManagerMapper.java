package com.notalent.bookstore.mapper;

import com.notalent.bookstore.pojo.manager.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员mapper层
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Mapper
public interface ManagerMapper {

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
