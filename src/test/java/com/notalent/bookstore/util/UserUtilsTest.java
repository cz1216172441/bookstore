package com.notalent.bookstore.util;

import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class UserUtilsTest {

    @Test
    public void isGenderError() {
        System.err.println(System.getProperty("user.dir"));
    }

    @Test
    public void isPhoneError() {
        String phone = "13112341234";
        Assert.assertEquals(true, UserUtils.isPhoneError(phone));
    }

    @Test
    public void isEmailError() {
        String email = "notalent@163.com";
        Assert.assertEquals(true, UserUtils.isEmailError(email));
    }
}