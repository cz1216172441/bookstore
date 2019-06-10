package com.notalent.bookstore.pojo.shoppingcart;

import com.notalent.bookstore.pojo.book.BookInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * ShoppingCartDetail
 * 购物车详情
 * @author noTalent
 * 2019-06-10 17:47
 * @version 1.0
 **/
@Data
@ToString
@NoArgsConstructor
public class ShoppingCartDetail implements Serializable {

    private static final long serialVersionUID = -4129808389495706201L;

    private Integer shoppingCartDetailId;       // 购物车详情id

    private Integer shoppingCartId;             // 购物车id

    private Integer bookInfoId;                 // 图书id

    private Integer bookQuantity;               // 图书数量

    private Date createTime;                    // 创建时间

    private Date updateTime;                    // 更新时间

    private BookInfo bookInfo;                  // 图书信息

}
