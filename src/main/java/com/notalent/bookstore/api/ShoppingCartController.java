package com.notalent.bookstore.api;

import com.notalent.bookstore.jwt.JwtUtils;
import com.notalent.bookstore.jwt.TokenValidation;
import com.notalent.bookstore.pojo.shoppingcart.ShoppingCartDetail;
import com.notalent.bookstore.service.ShoppingCartService;
import com.notalent.bookstore.util.IntegerUtils;
import com.notalent.bookstore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * ShoppingCartController
 * 购物车
 * @author noTalent
 * 2019-06-10 10:07
 * @version 1.0
 **/
@RestController
@RequestMapping("/shoppingCart/api")
@CrossOrigin("*")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 加入购物车
     * @param bookInfoId 图书id
     * @param request 请 求
     * @return result
     */
    @PostMapping("/v1/product/add")
    @TokenValidation
    public Result addToShoppingCart(Integer bookInfoId, HttpServletRequest request) {
        Integer userInfoId = JwtUtils.getUserInfoId(request.getHeader("Token"));
        Integer shoppingCartId = shoppingCartService.getShoppingCartId(userInfoId);
        if (IntegerUtils.isNotEmpty(shoppingCartId)) {
            // 购物车已存在此图书
            ShoppingCartDetail detail = shoppingCartService.getProduct(shoppingCartId, bookInfoId);
            if (detail != null) {
                // 商品数量 +1
                Integer quantity = detail.getBookQuantity() + IntegerUtils.ONE;
                detail.setBookQuantity(quantity);
                shoppingCartService.updateProductQuantity(detail);
                return Result.success();
            }
            // 购物车不存在此图书
            if (IntegerUtils.isNotEmpty(bookInfoId)) {
                detail.setBookInfoId(bookInfoId);
                detail.setBookQuantity(IntegerUtils.ONE);
                shoppingCartService.addShoppingCartDetail(detail);
                return Result.success();
            }
        }
        return Result.error();
    }

    /**
     * 改变图书数量
     * @param shoppingCartDetailId 购物车详情id
     * @param bookQuantity 图书数量
     * @return result
     */
    @PostMapping("/v1/book-quantity/update")
    @TokenValidation
    public Result updateBookQuantity(Integer shoppingCartDetailId, Integer bookQuantity) {
        if (IntegerUtils.isNotEmpty(shoppingCartDetailId) && IntegerUtils.isNotEmpty(bookQuantity)) {
            // 如果数量为0，删除商品
            if (bookQuantity == IntegerUtils.ZERO) {
                shoppingCartService.deleteProducts(shoppingCartDetailId);
            }
            // 数量不为0，修改商品数量
            ShoppingCartDetail detail = new ShoppingCartDetail();
            detail.setShoppingCartDetailId(shoppingCartDetailId);
            detail.setBookQuantity(bookQuantity);
            shoppingCartService.updateProductQuantity(detail);
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 删除单个商品
     * @param shoppingCartDetailId 购物车详情id
     * @return result
     */
    @PostMapping("/v1/product/delete")
    @TokenValidation
    public Result deleteProduct(Integer shoppingCartDetailId) {
        if (IntegerUtils.isNotEmpty(shoppingCartDetailId)) {
            shoppingCartService.deleteProduct(shoppingCartDetailId);
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 清空购物车
     * @param request 请 求
     * @return result
     */
    @PostMapping("/v1/products/delete")
    @TokenValidation
    public Result deleteProducts(HttpServletRequest request) {
        Integer userInfoId = JwtUtils.getUserInfoId(request.getHeader("Token"));
        Integer shoppingCartId = shoppingCartService.getShoppingCartId(userInfoId);
        if (IntegerUtils.isNotEmpty(shoppingCartId)) {
            shoppingCartService.deleteProducts(shoppingCartId);
            return Result.success();
        }
        return Result.error();
    }

}
