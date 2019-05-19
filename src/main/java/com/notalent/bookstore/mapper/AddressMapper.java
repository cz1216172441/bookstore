package com.notalent.bookstore.mapper;

import com.notalent.bookstore.pojo.user.Area;
import com.notalent.bookstore.pojo.user.ReceiverAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 地址mapper层
 * @author noTalent
 * @version 1.0
 * 2019.05.18
 */
@Mapper
public interface AddressMapper {

    // 添加地址
    Integer addAddress(ReceiverAddress address);

    // 根据地址id获取地址
    ReceiverAddress getAddressById(Integer receiverAddressId);

    // 根据用户id获取地址列表
    List<ReceiverAddress> listAddresses(Integer userInfoId);

    // 根据地区id获取地区
    Area getAreaById(Integer areaId);

    // 修改地址
    Integer updateAddress(ReceiverAddress address);

    // 删除地址
    Integer deleteAddress(Integer receiverAddressId);

}
