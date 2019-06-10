package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.shoppingcart.ShoppingCartDetail;

/**
 * 购物车服务层
 * @author noTalent
 * @version 1.0
 * 2019.06.10
 */
public interface ShoppingCartService {

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
    ShoppingCartDetail getProduct(Integer shoppingCartId, Integer bookInfoId);

}
