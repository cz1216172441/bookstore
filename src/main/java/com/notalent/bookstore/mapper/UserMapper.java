package com.notalent.bookstore.mapper;

import com.notalent.bookstore.pojo.user.UserInfo;

/**
 * 用户mapper层
 * @author noTalent
 * @version 1.0
 * 2019.05.08
 */
public interface UserMapper {

    // 添加用户信息
    Integer addUserInfo(UserInfo userInfo);

    // 获取用户密码与盐值
    UserInfo getPasswordAndSalt(String username);

}
