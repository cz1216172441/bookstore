package com.notalent.bookstore.pojo.user;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.08
 */

@Data
public class UserInfo {

    private Integer userInfoId;     // 用户信息id

    private String username;        // 用户名

    private String salt;            // 盐值

    private String password;        // 密  码

    private String userPhone;       // 手机号码

    private String userEmail;       // 电子邮件

    private Date createTime;        // 创建时间

    private Date updateTime;        // 更新时间

    private UserDetail userDetail;  // 用户详情

}
