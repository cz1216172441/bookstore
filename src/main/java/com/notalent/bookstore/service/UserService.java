package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.user.UserDetail;
import com.notalent.bookstore.pojo.user.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    Integer updatePassword(UserInfo userInfo);

    // 修改用户信息
    Integer updateUserInfo(UserInfo userInfo);

    // 修改用户详情
    Integer updateUserDetail(UserDetail userDetail);

    // 上传用户头像
    Integer uploadHeadPortrait(MultipartFile file, Integer userInfoId) throws IOException;

    // 根据用户信息id 获取用户信息
    UserInfo getUserInfoById(Integer userInfoId);

    // 根据用户信息id获取用户所有信息
    UserInfo getUserAllInfo(Integer userInfoId);

}
