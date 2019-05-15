package com.notalent.bookstore.pojo.advertisement;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 广告信息实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class AdvertisementInfo implements Serializable {

    private static final long serialVersionUID = 1963955443872586371L;

    private Integer advertisementInfoId;   // 广告信息id

    private String advertisementInfoTitle; // 广告标题

    private String advertisementInfoIntro; // 广告简介

    private String advertisementInfoImg;   // 广告图片

    private Date beginTime;                // 开始时间

    private Date endTime;                  // 结束时间

    private Date createTime;               // 创建时间

    private Date updateTime;               // 更新时间

    private Set<AdvertisementDetail> advertisementDetails;  // 广告详情

}
