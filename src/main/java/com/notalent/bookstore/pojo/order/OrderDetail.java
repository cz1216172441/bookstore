package com.notalent.bookstore.pojo.order;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 7001104050669961825L;

    private Integer orderDetailId;    // 订单详情id

    private String orderInfoId;       // 订单信息id

    private Integer bookInfoId;       // 图书信息id

    private Integer purchaseQuantity; // 购买数量

    private BigDecimal purchasePrice; // 购买价格

    private Date createTime;          // 创建时间

    private Date updateTime;          // 更新时间

}
