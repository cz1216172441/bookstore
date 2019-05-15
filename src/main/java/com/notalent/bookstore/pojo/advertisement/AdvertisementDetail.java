package com.notalent.bookstore.pojo.advertisement;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 广告详情实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class AdvertisementDetail implements Serializable {

    private static final long serialVersionUID = 1513294453991163768L;

    private Integer advertisementDetailId; // 广告详情id

    private Integer advertisementInfoId;   // 广告信息id

    private Integer bookInfoId;            // 图书信息id

    private BigDecimal purchaseDiscount;   // 促销折扣

    private Date createTime;               // 创建时间

    private Date updateTime;               // 更新时间

}
