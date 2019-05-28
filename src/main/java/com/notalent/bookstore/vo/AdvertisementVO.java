package com.notalent.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.notalent.bookstore.pojo.advertisement.AdvertisementInfo;
import com.notalent.bookstore.util.FileUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 广告展示对象
 * @author noTalent
 * @version 1.0
 * 2019.05.22
 */
@Data
@NoArgsConstructor
public class AdvertisementVO {

    @JsonProperty("id")
    private Integer advertisementInfoId;        // 广告信息id

    @JsonProperty("title")
    private String advertisementInfoTitle;      // 广告标题

    @JsonProperty("intro")
    private String advertisementInfoIntro;      // 广告简介

    @JsonProperty("img")
    private String advertisementInfoImg;        // 广告宣传图片

    @JsonProperty("beginTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date beginTime;                     // 广告开始时间

    @JsonProperty("endTime")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date endTime;                       // 广告结束时间

    public AdvertisementVO(AdvertisementInfo advertisementInfo, String root) {
        this.advertisementInfoId = advertisementInfo.getAdvertisementInfoId();
        this.advertisementInfoImg = FileUtils.imgUrlHandling(advertisementInfo.getAdvertisementInfoImg(), root);
        this.advertisementInfoIntro = advertisementInfo.getAdvertisementInfoIntro();
        this.advertisementInfoTitle = advertisementInfo.getAdvertisementInfoTitle();
        this.beginTime = advertisementInfo.getBeginTime();
        this.endTime = advertisementInfo.getEndTime();
    }

}
