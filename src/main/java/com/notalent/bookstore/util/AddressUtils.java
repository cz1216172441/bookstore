package com.notalent.bookstore.util;

import com.notalent.bookstore.pojo.user.ReceiverAddress;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 收货地址工具类
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
public class AddressUtils {

    private static final String POSTAL_CODE_REGEX = "^[0-9]\\d{5}$";

    // 地址是否合法
    public static boolean isAddressError(ReceiverAddress address) {
        if (address.getAddressStatus() != null &&
            StringUtils.isNotEmpty(address.getAddressDetail()) &&
            StringUtils.isNotEmpty(address.getReceiverPhone()) &&
            StringUtils.isNotEmpty(address.getReceiverName()) &&
            StringUtils.isNotEmpty(address.getPostalCode()) &&
            IntegerUtils.isNotEmpty(address.getAreaId()) &&
            !UserUtils.isPhoneError(address.getReceiverPhone()) &&
            !isPostalCodeError(address.getPostalCode())) {
            return false;
        }
        return true;
    }

    // 邮政编码是否合法
    public static boolean isPostalCodeError(String postalCode) {
        if (postalCode.matches(POSTAL_CODE_REGEX)) {
            return false;
        }
        return true;
    }

}
