package com.notalent.bookstore.pojo.manager;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限实体类
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = -6555243806855911522L;

    private Integer permissionId;   // 权限id

    private String permissionName;  // 权限名

    private String permissionUrl;   // 权限路径

    private Date createTime;        // 创建时间

}
