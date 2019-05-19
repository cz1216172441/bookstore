package com.notalent.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notalent.bookstore.pojo.user.ReceiverAddress;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址展示对象
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
@Data
@NoArgsConstructor
public class AddressVO {

    @JsonProperty("id")
    private Integer receiverAddressId;      // 收货地址id

    @JsonProperty("name")
    private String receiverName;            // 收货人姓名

    @JsonProperty("phone")
    private String receiverPhone;           // 收货人手机号码

    @JsonProperty("code")
    private String postalCode;              // 邮政编码

    @JsonProperty("areaId")
    private Integer areaId;                 // 地区id

    @JsonProperty("area")
    private String areaName;                // 地址

    @JsonProperty("address")
    private String receiverDetail;          // 详细地址

    @JsonProperty("default")
    private Boolean receiverStatus;         // 是否默认地址

    public AddressVO(ReceiverAddress address, String areaName) {
        this.areaName = areaName;
        this.postalCode = address.getPostalCode();
        this.areaId = address.getAreaId();
        this.receiverDetail = address.getAddressDetail();
        this.receiverAddressId = address.getReceiverAddressId();
        this.receiverStatus = address.getAddressStatus();
        this.receiverName = address.getReceiverName();
        this.receiverPhone = address.getReceiverPhone();
    }

}
