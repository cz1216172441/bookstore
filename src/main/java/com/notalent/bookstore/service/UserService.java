package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.user.UserInfo;

/**
 * 用户服务层
 * @author noTalent
 * @version 1.0
 * 2019.05.09
 */
public interface UserService {

    // 添加用户信息
    Integer addUserInfo(UserInfo userInfo);

    // 验证用户密码
    Boolean login(UserInfo ui);

}
