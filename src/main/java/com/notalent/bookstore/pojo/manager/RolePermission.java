package com.notalent.bookstore.pojo.manager;

import lombok.Data;

import java.util.Date;

/**
 * 角色权限实体类
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Data
public class RolePermission {

    private Integer roleId;        // 角色id

    private Integer permissionId;  // 权限id

    private Date createTime;       // 创建时间

}
