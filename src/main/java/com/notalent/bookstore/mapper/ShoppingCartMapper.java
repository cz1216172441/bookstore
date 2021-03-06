package com.notalent.bookstore.mapper;

import com.notalent.bookstore.pojo.shoppingcart.ShoppingCart;
import com.notalent.bookstore.pojo.shoppingcart.ShoppingCartDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 购物车mapper层
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Mapper
public interface ShoppingCartMapper {

    // 创建购物车
    Integer addShoppingCart(Integer userInfoId);

    // 加入购物车
    Integer addShoppingCartDetail(ShoppingCartDetail shoppingCartDetail);

    // 删除商品
    Integer deleteProduct(Integer shoppingCartDetailId);

    // 清空购物车
    Integer deleteProducts(Integer shoppingCartId);

    // 更新商品数量
    Integer updateProductQuantity(ShoppingCartDetail shoppingCartDetail);

    // 获取购物车id
    Integer getShoppingCartId(Integer userInfoId);

    // 获取商品
    ShoppingCartDetail getProduct(@Param("shoppingCartId") Integer shoppingCartId,
                                  @Param("bookInfoId") Integer bookInfoId);

}
