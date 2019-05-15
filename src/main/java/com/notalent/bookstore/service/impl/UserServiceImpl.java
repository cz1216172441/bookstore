package com.notalent.bookstore.service.impl;

import com.notalent.bookstore.mapper.UserMapper;
import com.notalent.bookstore.pojo.user.UserDetail;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.service.UserService;
import com.notalent.bookstore.shiro.ShiroUtils;
import com.notalent.bookstore.util.IntegerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
        if (IntegerUtils.isError(res)) {
            return IntegerUtils.ZERO;
        }
        UserDetail ud = new UserDetail(userInfo.getUserInfoId(), userInfo.getUsername());
        return userMapper.addUserDetail(ud);
    }

    @Override
    public Integer login(UserInfo ui) {
        UserInfo userInfo = userMapper.getPasswordAndSalt(ui.getUsername());
        // 加盐加密比对密码
        if (ShiroUtils.encrypt(ui.getPassword(), userInfo.getSalt()).equals(userInfo.getPassword())) {
            return userInfo.getUserInfoId();
        }
        return IntegerUtils.ZERO;
    }

    @Override
    public Integer alterPassword(UserInfo userInfo) {
        userInfo.setSalt(ShiroUtils.getSalt());
        userInfo.setPassword(ShiroUtils.encrypt(userInfo.getPassword(), userInfo.getSalt()));
        return userMapper.alterPassword(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Integer userInfoId) {
        return userMapper.getUserInfoById(userInfoId);
    }
}
