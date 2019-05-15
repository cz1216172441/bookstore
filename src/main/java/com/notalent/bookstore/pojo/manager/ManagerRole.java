package com.notalent.bookstore.pojo.manager;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员角色实体类
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
@Data
public class ManagerRole implements Serializable {

    private static final long serialVersionUID = 200425367114039189L;

    private Integer managerId;  // 管理员id

    private Integer roleId;     // 角色id

    private Date createTime;    // 创建时间

}
