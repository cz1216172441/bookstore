package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.user.Area;
import com.notalent.bookstore.pojo.user.ReceiverAddress;

import java.util.List;

/**
 * 地址服务层
 * @author noTalent
 * @version 1.0
 * 2019.05.19
 */
public interface AddressService {

    // 添加地址
    Integer addAddress(ReceiverAddress address);

    // 根据地址id获取地址
    ReceiverAddress getAddressById(Integer receiverAddressId);

    // 根据用户id获取地址列表
    List<ReceiverAddress> listAddresses(Integer userInfoId, Integer pageNum, Integer pageSize);

    // 根据地区id获取地区
    String getArea(Integer areaId);

    // 修改地址
    Integer updateAddress(ReceiverAddress address);

    // 删除地址
    Integer deleteAddress(Integer receiverAddressId);

}
