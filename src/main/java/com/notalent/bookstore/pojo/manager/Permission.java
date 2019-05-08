package com.notalent.bookstore.pojo.manager;

import lombok.Data;

import java.util.Date;

/**
 * 权限实体类
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Data
public class Permission {

    private Integer permissionId;   // 权限id

    private String permissionName;  // 权限名

    private String permissionUrl;   // 权限路径

    private Date createTime;        // 创建时间

}
