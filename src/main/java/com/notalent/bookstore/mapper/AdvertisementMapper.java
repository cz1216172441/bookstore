package com.notalent.bookstore.mapper;

import com.notalent.bookstore.pojo.advertisement.AdvertisementDetail;
import com.notalent.bookstore.pojo.advertisement.AdvertisementInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 广告mapper层
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Mapper
public interface AdvertisementMapper {

    // 添加广告信息
    Integer addAdvertisementInfo(AdvertisementInfo advertisementInfo);

    // 添加广告详情
    Integer addAdvertisementDetail(AdvertisementDetail advertisementDetail);

    // 获取广告信息
    AdvertisementInfo getAdvertisementById(Integer advertisementInfoId);

    // 获取广告列表
    List<AdvertisementInfo> listAdvertisementInfo();

}
