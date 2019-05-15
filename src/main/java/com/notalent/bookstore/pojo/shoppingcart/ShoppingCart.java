package com.notalent.bookstore.pojo.shoppingcart;

import com.notalent.bookstore.pojo.book.BookInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 购物车实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = -1966339087501105381L;

    private Integer shoppingCartId;  // 购物车id

    private Integer userInfoId;      // 用户信息id

    private Integer bookInfoId;      // 图书信息id

    private Integer bookQuantity;    // 图书数量

    private Date createTime;         // 创建时间

    private Date updateTime;         // 更新时间

    private Set<BookInfo> bookInfos; // 购物车图书

}
