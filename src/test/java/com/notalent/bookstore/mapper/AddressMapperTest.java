package com.notalent.bookstore.mapper;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.pojo.user.ReceiverAddress;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class AddressMapperTest {

    @Resource
    private AddressMapper addressMapper;

    @Test
    public void addAddress() {
        ReceiverAddress address = new ReceiverAddress();
        address.setUserInfoId(1);
        address.setAddressDetail("三灶镇吉林大学珠海学院");
        address.setAddressStatus(true);
        address.setPostalCode("000000");
        address.setAreaId(440404);
        address.setReceiverName("陈先生");
        address.setReceiverPhone("13112341234");
        int res = addressMapper.addAddress(address);
        Assert.assertEquals(1, res);
    }

    @Test
    public void getAddressById() {
        System.err.println(addressMapper.getAddressById(1));
    }

    @Test
    public void listAddresses() {
        System.err.println(addressMapper.listAddresses(1));
    }

    @Test
    public void getAreaById() {
        System.err.println(addressMapper.getAreaById(440404));
    }

    @Test
    public void updateAddress() {
        ReceiverAddress address = new ReceiverAddress();
        address.setReceiverAddressId(1);
        address.setPostalCode("000001");
        int res = addressMapper.updateAddress(address);
        Assert.assertEquals(1, res);
    }
}