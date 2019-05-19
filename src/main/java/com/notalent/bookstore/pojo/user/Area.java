package com.notalent.bookstore.pojo.user;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 地区实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.19
 */

@Data
@ToString
public class Area implements Serializable {

    private static final long serialVersionUID = -6965959074819198734L;

    private Integer areaId;         // 地区id

    private String areaName;        // 地区名

    private Integer superAreaId;    // 父地区id

}
