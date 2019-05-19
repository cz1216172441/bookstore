package com.notalent.bookstore.util;

import com.notalent.bookstore.pojo.user.ReceiverAddress;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class IntegerUtilsTest {

    @Test
    public void isEmpty() {
    }

    @Test
    public void isNotEmpty() {
    }

    @Test
    public void isError() {
    }

    @Test
    public void isNotError() {
        Integer res = null;
//        Assert.assertEquals(true, IntegerUtils.isError(res));
//        Assert.assertEquals(true, IntegerUtils.isError(new Integer(0)));
        Assert.assertEquals(true, IntegerUtils.isNotError(new Integer(1)));
    }

    @Test
    public void filterTest() {
        List<ReceiverAddress> addresses = null;
        addresses.stream().filter(address -> address.getAddressStatus()).collect(Collectors.toList());
    }
}