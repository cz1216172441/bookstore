package com.notalent.bookstore.service;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.pojo.user.ReceiverAddress;
import com.notalent.bookstore.util.AddressUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void regexTest() {
        String postalCode = "12345";
//        Assert.assertEquals(true, AddressUtils.isPostalCodeError(postalCode));
        Assert.assertEquals(true, postalCode.matches("^[0-9]\\d{5}"));
    }

    @Test
    public void addAddress() {
        ReceiverAddress address = new ReceiverAddress();
        address.setUserInfoId(1);
        address.setReceiverPhone("13100000000");
        address.setReceiverName("陈先生");
        address.setPostalCode("000000");
        address.setAddressStatus(true);
        address.setAreaId(710448);
        address.setAddressDetail("123456789");
        int res = addressService.addAddress(address);
        Assert.assertEquals(1, res);
    }

    @Test
    public void getAddressById() {
    }

    @Test
    public void listAddresses() {
    }

    @Test
    public void getAreaById() {
    }

    @Test
    public void updateAddress() {
    }
}