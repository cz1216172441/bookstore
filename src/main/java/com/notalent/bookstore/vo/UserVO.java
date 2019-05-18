package com.notalent.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.notalent.bookstore.pojo.user.UserInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户展示对象
 * @author noTalent
 * @version 1.0
 * 2019.05.18
 */
@Data
@NoArgsConstructor
public class UserVO implements Serializable {

    private static final long serialVersionUID = -4067055168413317525L;

    @JsonProperty("id")
    private Integer userInfoId;     // 用户信息id

    @JsonProperty("username")
    private String username;        // 用户名

    @JsonProperty("nickname")
    private String userNickname;    // 用户昵称

    @JsonProperty("gender")
    private String userGender;      // 用户性别

    @JsonProperty("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date userBirthday;      // 出生日期

    @JsonProperty("img")
    private String userImg;         // 用户头像

    @JsonProperty("phone")
    private String userPhone;       // 手机号码

    @JsonProperty("email")
    private String userEmail;       // 电子邮箱

    public UserVO(UserInfo ui) {
        userInfoId = ui.getUserInfoId();
        userNickname = ui.getUserDetail().getUserNickname();
        userGender = ui.getUserDetail().getUserGender();
        userBirthday = ui.getUserDetail().getUserBirthday();
        userImg = ui.getUserDetail().getUserImg();
        username = ui.getUsername();
        String phone = ui.getUserPhone();
        if (StringUtils.isEmpty(phone)) {
            userPhone = StringUtils.EMPTY;
        } else {
            userPhone = phone;
        }
        String email = ui.getUserEmail();
        if (StringUtils.isEmpty(email)) {
            userEmail = StringUtils.EMPTY;
        } else {
            userEmail = email;
        }
    }

}
