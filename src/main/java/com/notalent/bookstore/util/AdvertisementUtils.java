package com.notalent.bookstore.util;

import com.notalent.bookstore.pojo.advertisement.AdvertisementInfo;
import org.apache.commons.lang3.StringUtils;

/**
 * 广告工具
 * @author noTalent
 * @version 1.0
 * 2019.05.30
 */
public class AdvertisementUtils {

    public static boolean isError(AdvertisementInfo advertisement) {
        if (StringUtils.isEmpty(advertisement.getAdvertisementInfoTitle())) {
            return true;
        }
        if (StringUtils.isEmpty(advertisement.getAdvertisementInfoIntro())) {
            advertisement.setAdvertisementInfoIntro(StringUtils.EMPTY);
        }
        if (advertisement.getBeginTime() == null || advertisement.getEndTime() == null) {
            return true;
        }
        if (advertisement.getBeginTime().after(advertisement.getEndTime())) {
            return true;
        }
        return false;
    }

}
