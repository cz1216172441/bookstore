package com.notalent.bookstore.api;

import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.pojo.advertisement.AdvertisementInfo;
import com.notalent.bookstore.service.AdvertisementService;
import com.notalent.bookstore.util.FileUtils;
import com.notalent.bookstore.util.Result;
import com.notalent.bookstore.vo.AdvertisementVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/advertisement/api")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/v1/advertisement/list")
    @CrossTokenValidation
    public Result listAdvertisement(@RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize) {
        List<AdvertisementInfo> advertisementInfos = advertisementService.listAdvertisementInfo(pageNum, pageSize);
        List<AdvertisementVO> advertisementVOS = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(advertisementInfos)) {
            Iterator<AdvertisementInfo> infoIterator = advertisementInfos.iterator();
            String root = FileUtils.ROOT_URL + FileUtils.ADVERTISEMENT_VISIT_URL;
            while (infoIterator.hasNext()) {
                advertisementVOS.add(new AdvertisementVO(infoIterator.next(), root));
            }
        }
        return Result.success(advertisementVOS);
    }

}
