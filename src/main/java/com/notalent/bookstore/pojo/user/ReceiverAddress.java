package com.notalent.bookstore.pojo.user;

import lombok.Data;

import java.util.Date;

/**
 * 收货地址实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.08
 */

@Data
public class ReceiverAddress {

    private Integer receiverAddressId;  // 收货地址id

    private Integer userInfoId;         // 用户信息id

    private String receiverName;        // 收货人姓名

    private String receiverPhone;       // 收货人手机号码

    private String postalCode;          // 邮政编码

    private Integer provinceId;         // 省id

    private Integer cityId;             // 市id

    private Integer countyId;           // 区id

    private String addressDetail;       // 详细地址

    private Date createTime;            // 创建时间

    private Date updateTime;            // 更新时间

}
