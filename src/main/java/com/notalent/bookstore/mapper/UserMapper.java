package com.notalent.bookstore.mapper;

import com.notalent.bookstore.pojo.user.UserDetail;
import com.notalent.bookstore.pojo.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper层
 * @author noTalent
 * @version 1.0
 * 2019.05.08
 */
@Mapper
public interface UserMapper {

    // 添加用户信息
    Integer addUserInfo(UserInfo userInfo);

    // 添加用户详情
    Integer addUserDetail(UserDetail userDetail);

    // 获取用户密码与盐值
    UserInfo getPasswordAndSalt(String username);

    // 根据用户信息id 获取用户信息
    UserInfo getUserInfoById(Integer userInfoId);

    // 修改密码
    Integer alterPassword(UserInfo userInfo);

}
