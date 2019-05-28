package com.notalent.bookstore.service.impl;

import com.notalent.bookstore.mapper.UserMapper;
import com.notalent.bookstore.pojo.user.UserDetail;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.service.UserService;
import com.notalent.bookstore.shiro.ShiroUtils;
import com.notalent.bookstore.util.FileUtils;
import com.notalent.bookstore.util.IntegerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 用户服务层实现
 * @author noTalent
 * @version 1.0
 * 2019.05.09
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public Integer register(UserInfo userInfo) {
        // 加盐加密
        String salt = ShiroUtils.getSalt();
        userInfo.setSalt(salt);
        userInfo.setPassword(ShiroUtils.encrypt(userInfo.getPassword(), salt));
        // 插入数据库
        Integer res = userMapper.addUserInfo(userInfo);
        if (IntegerUtils.isNotError(res)) {
            UserDetail ud = new UserDetail(userInfo.getUserInfoId(), "用户" + System.currentTimeMillis());
            return userMapper.addUserDetail(ud);
        }
        return IntegerUtils.ZERO;
    }

    @Override
    public Integer login(UserInfo ui) {
        UserInfo userInfo = userMapper.getPasswordAndSalt(ui.getUsername());
        if (userInfo != null) {
            // 加盐加密比对密码
            if (ShiroUtils.encrypt(ui.getPassword(), userInfo.getSalt()).equals(userInfo.getPassword())) {
                return userInfo.getUserInfoId();
            }
        }
        return IntegerUtils.ZERO;
    }

    @Override
    public Integer updatePassword(UserInfo userInfo) {
        userInfo.setSalt(ShiroUtils.getSalt());
        userInfo.setPassword(ShiroUtils.encrypt(userInfo.getPassword(), userInfo.getSalt()));
        return userMapper.updateUserInfo(userInfo);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return userMapper.updateUserInfo(userInfo);
    }

    @Override
    public Integer updateUserDetail(UserDetail userDetail) {
        return userMapper.updateUserDetail(userDetail);
    }

    @Override
    public UserInfo getUserInfoById(Integer userInfoId) {
        return userMapper.getUserInfoById(userInfoId);
    }

    @Override
    public UserInfo getUserAllInfo(Integer userInfoId) {
        return userMapper.getUserAllInfo(userInfoId);
    }

    @Override
    @Transactional
    public Integer uploadHeadPortrait(MultipartFile file, Integer userInfoId) throws IOException {
        // 上传头像
        String fileName = FileUtils.uploadFile(file, FileUtils.FILE_URL + FileUtils.USER_UPLOAD_URL);
        // 删除旧头像
        UserInfo ui = userMapper.getUserAllInfo(userInfoId);
        String userImg = ui.getUserDetail().getUserImg();
        if (StringUtils.isNotEmpty(userImg)) {
            FileUtils.deleteFile(userImg, FileUtils.FILE_URL + FileUtils.USER_UPLOAD_URL);
        }
        UserDetail ud = new UserDetail();
        ud.setUserInfoId(userInfoId);
        ud.setUserImg(fileName);
        return userMapper.updateUserDetail(ud);
    }
}
