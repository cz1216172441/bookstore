package com.notalent.bookstore.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 性别工具类
 * @author noTalent
 * @version 1.0
 * 2019.05.18
 */
public class UserUtils {

    public static final String MALE = "男";

    public static final String FEMALE = "女";

    public static final String REGEX_PHONE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";

    public static final String REGEX_EMAIL = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";

    public static final String ASTERISK = "******";

    // 性别是否不规范
    public static boolean isGenderError(String gender) {
        if (gender.length() != 1) return true;
        if (gender.equals(MALE) || gender.equals(FEMALE)) {
            return false;
        }
        return true;
    }

    // 手机号码是否不规范
    public static boolean isPhoneError(String phone) {
        if (phone.length() != 11) return true;
        if (phone.matches(REGEX_PHONE)) return false;
        return true;
    }

    // 电子邮箱是否不规范
    public static boolean isEmailError(String email) {
        if (StringUtils.isEmpty(email)) return true;
        if (email.matches(REGEX_EMAIL)) return false;
        return true;
    }

    // 手机号码隐藏
    public static String phoneEncrypt(String phone) {
        return phone.substring(0, 3) + ASTERISK + phone.substring(9, 11);
    }
}

