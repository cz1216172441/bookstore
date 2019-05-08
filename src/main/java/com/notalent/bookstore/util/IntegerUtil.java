package com.notalent.bookstore.util;

/**
 * Integer工具
 * @author noTalent
 * @version 1.0
 * 2019.05.09
 */
public class IntegerUtil {

    public static boolean isEmpty(Integer num) {
        return num == null;
    }

    public static boolean isNotEmpty(Integer num) {
        return !isEmpty(num);
    }

    public static boolean isError(Integer num) {
        return isEmpty(num) && num == 0 ? true : false;
    }

}
