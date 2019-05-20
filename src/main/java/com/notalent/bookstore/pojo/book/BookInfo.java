package com.notalent.bookstore.pojo.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 图书信息实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@ToString
@NoArgsConstructor
public class BookInfo implements Serializable {

    private static final long serialVersionUID = 5092926411798784794L;

    private Integer bookInfoId;  // 图书信息id

    private Integer categoryId;  // 图书分类id

    private String bookInfoImg;  // 图书封面图片

    private String bookName;     // 图书名称

    private String bookAuthor;   // 图书作者

    private BigDecimal bookActualPrice;    // 图书实际价格

    private BigDecimal bookOriginalPrice;  // 图书原价

    private Boolean bookStatus;            // 图书状态

    private Date createTime;               // 创建时间

    private Date updateTime;               // 更新时间

    private BookDetail bookDetail;         // 图书详情

    private BookCategory bookCategory;     // 图书分类

    private BookSku bookSku;               // 图书库存

    public BookInfo(Integer bookInfoId, String bookInfoImg) {
        this.bookInfoId = bookInfoId;
        this.bookInfoImg = bookInfoImg;
    }

}
