package com.notalent.bookstore.util;

import org.junit.Assert;
import org.junit.Test;

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
}