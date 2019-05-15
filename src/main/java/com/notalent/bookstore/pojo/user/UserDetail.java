package com.notalent.bookstore.pojo.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户详情实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.08
 */

@Data
@NoArgsConstructor
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 8646581942676218776L;

    private Integer userDetailId;  // 用户详情id

    private Integer userInfoId;    // 用户信息id

    private String userImg;        // 用户头像

    private String userNickname;   // 用户昵称

    private String userGender;     // 用户性别

    private Date userBirthday;     // 用户出生日期

    private Date createTime;       // 创建时间

    private Date updateTime;       // 更新时间

    public UserDetail(Integer userInfoId, String userNickname) {
        this.userInfoId = userInfoId;
        this.userNickname = userNickname;
    }

}
