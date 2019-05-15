package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.user.UserInfo;

/**
 * 用户服务层
 * @author noTalent
 * @version 1.0
 * 2019.05.09
 */
public interface UserService {

    // 注册
    Integer register(UserInfo userInfo);

    // 验证用户密码
    Integer login(UserInfo ui);

    // 修改密码
    Integer alterPassword(UserInfo userInfo);

    // 根据用户信息id 获取用户信息
    UserInfo getUserInfoById(Integer userInfoId);

}
