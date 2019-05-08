package com.notalent.bookstore.service.impl;

import com.notalent.bookstore.mapper.UserMapper;
import com.notalent.bookstore.pojo.user.UserInfo;
import com.notalent.bookstore.service.UserService;
import com.notalent.bookstore.shiro.ShiroUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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
    public Integer addUserInfo(UserInfo userInfo) {
        // 加盐加密
        String salt = ShiroUtil.getSalt();
        userInfo.setSalt(salt);
        userInfo.setPassword(ShiroUtil.encrypt(userInfo.getPassword(), salt));
        // 手机号码与电子邮箱不为null
        if (StringUtils.isBlank(userInfo.getUserPhone())) {
            userInfo.setUserPhone("");
        }
        if (StringUtils.isBlank(userInfo.getUserEmail())) {
            userInfo.setUserEmail("");
        }
        return userMapper.addUserInfo(userInfo);
    }

    @Override
    public Boolean login(UserInfo ui) {
        UserInfo userInfo = userMapper.getPasswordAndSalt(ui.getUsername());
        // 加盐加密比对密码
        return ShiroUtil.encrypt(ui.getPassword(), userInfo.getSalt()).equals(userInfo.getPassword());
    }

}
