package com.notalent.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.notalent.bookstore.mapper.AdvertisementMapper;
import com.notalent.bookstore.pojo.advertisement.AdvertisementDetail;
import com.notalent.bookstore.pojo.advertisement.AdvertisementInfo;
import com.notalent.bookstore.service.AdvertisementService;
import com.notalent.bookstore.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 广告服务层实现
 * @author noTalent
 * @version 1.0
 * 2019.05.22
 */
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {

    @Resource
    private AdvertisementMapper advertisementMapper;

    @Override
    @Transactional
    public Integer addAdvertisementInfo(MultipartFile file, AdvertisementInfo advertisementInfo) throws IOException {
        String root = FileUtils.FILE_URL + FileUtils.ADVERTISEMENT_UPLOAD_URL;
        String fileName = FileUtils.uploadFile(file, root);
        advertisementInfo.setAdvertisementInfoImg(fileName);
        return advertisementMapper.addAdvertisementInfo(advertisementInfo);
    }

    @Override
    public Integer addAdvertisementDetail(AdvertisementDetail advertisementDetail) {
        return advertisementMapper.addAdvertisementDetail(advertisementDetail);
    }

    @Override
    public AdvertisementInfo getAdvertisementById(Integer advertisementInfoId) {
        return advertisementMapper.getAdvertisementById(advertisementInfoId);
    }

    @Override
    public List<AdvertisementInfo> listAdvertisementInfo() {
        return advertisementMapper.listAdvertisementInfo();
    }

    @Override
    public List<AdvertisementInfo> listAdvertisementInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return advertisementMapper.listAdvertisementInfo();
    }
}
