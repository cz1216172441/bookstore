package com.notalent.bookstore.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {

    @Test
    public void jsonTest() {
        Object o = JSON.parse(Result.error().toString());
        System.err.println(o);
    }

}