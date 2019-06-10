package com.notalent.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.notalent.bookstore.pojo.book.BookInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * 图书展示对象
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
@Data
@NoArgsConstructor
public class BookVO {

    @JsonProperty("id")
    private Integer bookInfoId;     // 图书信息id

    @JsonProperty("category")
    private String categoryName;    // 图书分类

    @JsonProperty("name")
    private String bookName;        // 图书名称

    @JsonProperty("author")
    private String bookAuthor;      // 图书作者

    @JsonProperty("intro")
    private String bookIntro;       // 图书简介

    @JsonProperty("publisher")
    private String publishingHouse; // 出版社

    @JsonProperty("pubDate")
    @JsonFormat(pattern = "yyyy年MM月")
    private Date publishingTime;    // 出版时间

    @JsonProperty("isbn")
    private String bookIsbn;        // ISBN

    @JsonProperty("actualPrice")
    private String bookActualPrice;         // 图书实际价格

    @JsonProperty("originalPrice")
    private String bookOriginalPrice;       // 原价

    @JsonProperty("stock")
    private Integer bookStock;              // 库存数量

    @JsonProperty("status")
    private Boolean bookStatus;             // 图书状态

    @JsonProperty("infoImg")
    private String[] bookInfoImg;             // 图书封面图片

    @JsonProperty("detailImg")
    private String bookDetailImg;           // 图书详情图片

    public BookVO(BookInfo bookInfo, String categoryName) {
        this.bookInfoId = bookInfo.getBookInfoId();
        this.bookName = bookInfo.getBookName();
        this.bookAuthor = bookInfo.getBookAuthor();
        String tmp = bookInfo.getBookInfoImg();
        if (tmp.contains(";")) {
            this.bookInfoImg = tmp.split(";");
        } else {
            this.bookInfoImg = new String[1];
            this.bookInfoImg[0] = tmp;
        }
        DecimalFormat format = new DecimalFormat("0.00");
        this.bookActualPrice = format.format(bookInfo.getBookActualPrice());
        this.bookOriginalPrice = format.format(bookInfo.getBookOriginalPrice());
        this.bookStatus = bookInfo.getBookStatus();
        this.bookDetailImg = bookInfo.getBookDetail().getBookDetailImg();
        this.bookIntro = bookInfo.getBookDetail().getBookIntro();
        this.bookIsbn = bookInfo.getBookDetail().getBookIsbn();
        this.publishingHouse = bookInfo.getBookDetail().getPublishingHouse();
        this.publishingTime = bookInfo.getBookDetail().getPublishingTime();
        this.bookStock = bookInfo.getBookSku().getBookStock();
        this.categoryName = categoryName;
    }

}
