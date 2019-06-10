package com.notalent.bookstore.service.impl;

import com.notalent.bookstore.mapper.ShoppingCartMapper;
import com.notalent.bookstore.pojo.shoppingcart.ShoppingCart;
import com.notalent.bookstore.pojo.shoppingcart.ShoppingCartDetail;
import com.notalent.bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ShoppingCartServiceImpl
 * 购物车服务层实现
 * @author noTalent
 * 2019-06-10 14:11
 * @version 1.0
 **/
@Service("shoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public Integer addShoppingCart(Integer userInfoId) {
        return shoppingCartMapper.addShoppingCart(userInfoId);
    }

    @Override
    public Integer addShoppingCartDetail(ShoppingCartDetail shoppingCartDetail) {
        return shoppingCartMapper.addShoppingCartDetail(shoppingCartDetail);
    }

    @Override
    public Integer deleteProduct(Integer shoppingCartDetailId) {
        return shoppingCartMapper.deleteProduct(shoppingCartDetailId);
    }

    @Override
    public Integer deleteProducts(Integer shoppingCartId) {
        return shoppingCartMapper.deleteProducts(shoppingCartId);
    }

    @Override
    public Integer updateProductQuantity(ShoppingCartDetail shoppingCartDetail) {
        return shoppingCartMapper.updateProductQuantity(shoppingCartDetail);
    }

    @Override
    public Integer getShoppingCartId(Integer userInfoId) {
        return shoppingCartMapper.getShoppingCartId(userInfoId);
    }

    @Override
    public ShoppingCartDetail getProduct(Integer shoppingCartId, Integer bookInfoId) {
        return shoppingCartMapper.getProduct(shoppingCartId, bookInfoId);
    }
}
