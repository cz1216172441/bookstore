package com.notalent.bookstore.service;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.mapper.ShoppingCartMapper;
import com.notalent.bookstore.pojo.shoppingcart.ShoppingCart;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class ShoppingCartServiceTest {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;

}