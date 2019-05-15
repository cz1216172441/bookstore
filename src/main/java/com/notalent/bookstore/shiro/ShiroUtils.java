package com.notalent.bookstore.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * Shiro工具类
 * @author noTalent
 * @version 1.0
 * 2019.04.18
 */
public class ShiroUtils {

    // 获取随机盐值
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    // 加盐加密
    public static String encrypt(Object pwd, String salt) {
        return new SimpleHash("MD5", pwd, salt, 1024).toString();
    }

}
