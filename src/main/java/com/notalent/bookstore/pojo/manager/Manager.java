package com.notalent.bookstore.pojo.manager;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体类
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Data
public class Manager implements Serializable {

    private static final long serialVersionUID = -2098376068372967219L;

    private Integer managerId;  // 管理员id

    private String username;    // 用户名

    private String password;    // 密码

    private String salt;        // 盐值

    private Set<Role> roles = new HashSet<>();  // 角色列表

    private Date createTime;    // 创建时间

    private Date updateTime;    // 更改时间

}
