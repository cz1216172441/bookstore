package com.notalent.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Token展示对象
 * @author noTalent
 * @version 1.0
 * 2019.05.24
 */
@Data
@AllArgsConstructor
public class TokenVO {

    @JsonProperty("token")
    private String token;       // token

    @JsonProperty("expires")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date expires;       // token过期时间

}
