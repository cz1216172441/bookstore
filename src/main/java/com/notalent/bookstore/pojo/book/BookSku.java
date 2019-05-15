package com.notalent.bookstore.pojo.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书库存实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class BookSku implements Serializable {

    private static final long serialVersionUID = -3678027461585440378L;

    private Integer bookSkuId;       // 库存id

    private Integer bookInfoId;      // 图书信息id

    private Integer bookStock;       // 图书库存

    private String bookSkuProperty;  // 库存属性

    private Date createTime;         // 创建时间

    private Date updateTime;         // 更新时间

}
