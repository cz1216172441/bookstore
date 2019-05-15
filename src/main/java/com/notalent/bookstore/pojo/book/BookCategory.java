package com.notalent.bookstore.pojo.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书分类实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class BookCategory implements Serializable {

    private static final long serialVersionUID = -7180933457233429742L;

    private Integer bookCategoryId;  // 图书分类id

    private Integer superCategoryId; // 图书父分类id

    private String categoryName;     // 分类名

    private Date createTime;         // 创建时间

    private Date updateTime;         // 更新时间

}
