package com.notalent.bookstore.pojo.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书详情实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class BookDetail implements Serializable {

    private static final long serialVersionUID = 832230143048713165L;

    private Integer bookDetailId;   // 图书详情id

    private Integer bookInfoId;     // 图书信息id

    private String bookIntro;       // 图书简介

    private String publishingHouse; // 出版社

    private String publishingTime;  // 出版时间

    private String bookIsbn;        // ISBN

    private String bookDetailImg;   // 图书详情图片

    private Date createTime;        // 创建时间

    private Date updateTime;        // 更新时间

}
