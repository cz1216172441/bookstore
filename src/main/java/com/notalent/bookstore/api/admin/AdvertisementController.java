package com.notalent.bookstore.api.admin;

import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.pojo.advertisement.AdvertisementInfo;
import com.notalent.bookstore.service.AdvertisementService;
import com.notalent.bookstore.util.IntegerUtils;
import com.notalent.bookstore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 广告管理控制层
 * @author noTalent
 * @version 1.0
 * 2019.05.22
 */
@RestController("advertisementAdminController")
@RequestMapping("/advertisement-admin/api")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping("/v1/advertisement/add")
    @CrossTokenValidation
    public Result addAdvertisementInfo(@RequestParam("file") MultipartFile file,
                                       AdvertisementInfo advertisementInfo) throws IOException {
        if (IntegerUtils.isNotError(advertisementService.addAdvertisementInfo(file, advertisementInfo))) {
            return Result.success();
        }
        return Result.error();
    }

}
