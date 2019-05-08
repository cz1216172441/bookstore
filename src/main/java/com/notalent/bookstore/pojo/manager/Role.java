package com.notalent.bookstore.pojo.manager;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色实体类
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Data
public class Role {

    private Integer roleId;  // 角色id

    private String roleName; // 角色名

    private Set<Permission> permissions = new HashSet<>();  // 权限列表

    private Set<Manager> managers = new HashSet<>();  // 管理员列表

    private Date createTime; // 创建时间

}
