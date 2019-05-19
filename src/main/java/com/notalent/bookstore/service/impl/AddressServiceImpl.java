package com.notalent.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.notalent.bookstore.mapper.AddressMapper;
import com.notalent.bookstore.pojo.user.Area;
import com.notalent.bookstore.pojo.user.ReceiverAddress;
import com.notalent.bookstore.service.AddressService;
import com.notalent.bookstore.util.IntegerUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 地址服务层实现
 * @author noTalent
 * @version 1.0
 * 2019.04.19
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    @Transactional
    public Integer addAddress(ReceiverAddress address) {
        // address为默认地址，需要将其它设为非默认地址
        updateAddressStatus(address);
        return addressMapper.addAddress(address);
    }

    @Override
    public ReceiverAddress getAddressById(Integer receiverAddressId) {
        return addressMapper.getAddressById(receiverAddressId);
    }

    @Override
    public List<ReceiverAddress> listAddresses(Integer userInfoId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return addressMapper.listAddresses(userInfoId);
    }

    @Override
    public String getArea(Integer areaId) {
        Area area = addressMapper.getAreaById(areaId);
        String res = area.getAreaName();
        while (area.getSuperAreaId() != IntegerUtils.ZERO) {
            area = addressMapper.getAreaById(area.getSuperAreaId());
            res = area.getAreaName() + res;
        }
        return res;
    }

    @Override
    @Transactional
    public Integer updateAddress(ReceiverAddress address) {
        updateAddressStatus(address);
        return addressMapper.updateAddress(address);
    }

    @Override
    public Integer deleteAddress(Integer receiverAddressId) {
        return addressMapper.deleteAddress(receiverAddressId);
    }

    // 遍历地址更新地址默认状态
    public void updateAddressStatus(ReceiverAddress address) {
        if (address.getAddressStatus()) {
            List<ReceiverAddress> addresses = addressMapper.listAddresses(address.getUserInfoId());
            if (CollectionUtils.isNotEmpty(addresses)) {
                addresses.stream()
                         .filter(add -> add.getAddressStatus())
                         .forEach(add -> {
                             add.setAddressStatus(false);
                             addressMapper.updateAddress(add);
                         });
            }
        }
    }

}
