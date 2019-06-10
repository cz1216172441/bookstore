package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.advertisement.AdvertisementDetail;
import com.notalent.bookstore.pojo.advertisement.AdvertisementInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 广告服务层
 * @author noTalent
 * @version 1.0
 * 2019.05.22
 */
public interface AdvertisementService {

    // 添加广告信息
    Integer addAdvertisementInfo(MultipartFile file, AdvertisementInfo advertisementInfo) throws IOException;

    // 添加广告详情
    Integer addAdvertisementDetail(AdvertisementDetail advertisementDetail);

    // 获取广告信息
    AdvertisementInfo getAdvertisementById(Integer advertisementInfoId);

    // 获取广告列表
    List<AdvertisementInfo> listAdvertisementInfo();

    // 获取广告列表
    List<AdvertisementInfo> listAdvertisementInfo(Integer pageNum, Integer pageSize);

    // 修改广告信息
    Integer updateAdvertisement(MultipartFile file, AdvertisementInfo advertisementInfo) throws IOException;

}
