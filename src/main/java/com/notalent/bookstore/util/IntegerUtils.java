package com.notalent.bookstore.util;

/**
 * Integer工具
 * @author noTalent
 * @version 1.0
 * 2019.05.09
 */
public class IntegerUtils {

    public static final Integer ZERO = 0;

    public static final Integer ONE = 1;

    public static boolean isEmpty(Integer num) {
        return num == null;
    }

    public static boolean isNotEmpty(Integer num) {
        return !isEmpty(num);
    }

    public static boolean isError(Integer num) {
        return isEmpty(num) || num == 0 ? true : false;
    }

    public static boolean isNotError(Integer num) {
        return !isError(num) && num > 0;
    }

}
