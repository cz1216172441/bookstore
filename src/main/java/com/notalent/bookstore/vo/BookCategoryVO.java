package com.notalent.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.notalent.bookstore.pojo.book.BookCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图书分类展示对象
 * @author noTalent
 * @version 1.0
 * 2019.05.22
 */
@Data
@NoArgsConstructor
public class BookCategoryVO {

    @JsonProperty("id")
    private Integer categoryId;         // 图书分类id

    @JsonProperty("name")
    private String categoryName;       // 图书分类名

    @JsonProperty("superId")
    private Integer superCategoryId;    // 图书父级分类id

    public BookCategoryVO(BookCategory category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
        this.superCategoryId = category.getSuperCategoryId();
    }


}
