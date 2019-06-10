package com.notalent.bookstore.api;

import com.notalent.bookstore.jwt.JwtUtils;
import com.notalent.bookstore.jwt.TokenValidation;
import com.notalent.bookstore.pojo.user.ReceiverAddress;
import com.notalent.bookstore.service.AddressService;
import com.notalent.bookstore.util.AddressUtils;
import com.notalent.bookstore.util.IntegerUtils;
import com.notalent.bookstore.util.Result;
import com.notalent.bookstore.util.UserUtils;
import com.notalent.bookstore.vo.AddressVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 收货地址api
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
@RestController
@RequestMapping("/address/api")
@CrossOrigin("*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 添加地址
     * @param address 地址信息
     * @param request 请    求
     * @return result
     */
    @PostMapping("/v1/address/add")
    @TokenValidation
    public Result addAddress(ReceiverAddress address, HttpServletRequest request) {
        Integer userInfoId = JwtUtils.getUserInfoId(request);
        if (IntegerUtils.isNotEmpty(userInfoId)) {
            address.setUserInfoId(userInfoId);
            if (AddressUtils.isAddressError(address)) {
                return Result.error();
            }
            if (IntegerUtils.isNotError(addressService.addAddress(address))) {
                return Result.success();
            }
        }
        return Result.error();
    }

    /**
     * 修改地址信息
     * @param address 地址信息
     * @param request 请    求
     * @return result
     */
    @PostMapping("v1/address/update")
    @TokenValidation
    public Result updateAddress(ReceiverAddress address, HttpServletRequest request) {
        Integer userInfoId = JwtUtils.getUserInfoId(request);
        if (IntegerUtils.isNotEmpty(userInfoId)) {
            String postalCode = address.getPostalCode();
            String receiverPhone = address.getReceiverPhone();
            // 邮政编码不合法
            if (StringUtils.isNotEmpty(postalCode) &&
                    AddressUtils.isPostalCodeError(postalCode)) {
                return Result.error();
            }
            // 收货人手机号码不合法
            if (StringUtils.isNotEmpty(receiverPhone) &&
                    UserUtils.isPhoneError(receiverPhone)) {
                return Result.error();
            }
            if (IntegerUtils.isNotError(addressService.updateAddress(address))) {
                return Result.success();
            }
        }
        return Result.error();
    }

    /**
     * 获取某个地址
     * @param receiverAddressId 收货地址id
     * @param request 请   求
     * @return result
     */
    @GetMapping("v1/address/get")
    @TokenValidation
    public Result getAddress(@RequestParam("receiverAddressId") Integer receiverAddressId,
                             HttpServletRequest request) {
        Integer userInfoId = JwtUtils.getUserInfoId(request);
        if (IntegerUtils.isNotEmpty(userInfoId)) {
            ReceiverAddress address = addressService.getAddressById(receiverAddressId);
            if (address != null && address.getUserInfoId() == userInfoId) {
                String areaName = addressService.getArea(address.getAreaId());
                if (StringUtils.isNotEmpty(areaName)) {
                    return Result.success(new AddressVO(address, areaName));
                }
            }
        }
        return Result.error();
    }

    /**
     * 获取地址列表
     * @param pageNum 页码
     * @param pageSize 数目
     * @param request 请 求
     * @return result
     */
    @GetMapping("/v1/address/list")
    @TokenValidation
    public Result listAddress(@RequestParam("pageNum") Integer pageNum,
                              @RequestParam("pageSize") Integer pageSize,
                              HttpServletRequest request) {
        Integer userInfoId = JwtUtils.getUserInfoId(request);
        if (IntegerUtils.isNotEmpty(userInfoId)) {
            List<ReceiverAddress> addresses = addressService.listAddresses(userInfoId, pageNum, pageSize);
            if (CollectionUtils.isNotEmpty(addresses)) {
                List<AddressVO> addressVOS = new ArrayList<>();
                Iterator<ReceiverAddress> it = addresses.iterator();
                while (it.hasNext()) {
                    ReceiverAddress receiverAddress = it.next();
                    String areaName = addressService.getArea(receiverAddress.getAreaId());
                    if (StringUtils.isNotEmpty(areaName)) {
                        addressVOS.add(new AddressVO(receiverAddress, areaName));
                    } else {
                        addressVOS.add(new AddressVO(receiverAddress, StringUtils.EMPTY));
                    }
                }
                return Result.success(addressVOS);
            }
        }
        return Result.error();
    }

    /**
     * 删除地址
     * @param receiverAddressId 收货地址id
     * @param request 请   求
     * @return result
     */
    @PostMapping("/v1/address/delete")
    @TokenValidation
    public Result deleteAddress(@RequestParam("receiverAddressId") Integer receiverAddressId,
                                HttpServletRequest request) {
        Integer userInfoId = JwtUtils.getUserInfoId(request);
        if (IntegerUtils.isNotEmpty(userInfoId)) {
            if (IntegerUtils.isNotError(addressService.deleteAddress(receiverAddressId))) {
                return Result.success();
            }
        }
        return Result.error();
    }

}
