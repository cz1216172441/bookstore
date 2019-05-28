package com.notalent.bookstore.pojo.order;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 订单信息实体类
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Data
@NoArgsConstructor
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = -8941236427804958763L;

    private String orderInfoId;        // 订单信息id

    private Integer userInfoId;         // 用户信息id

    private Integer receiverAddressId;  // 收货地址id

    private String paymentMode;         // 支付方式

    private String paymentOrder;        // 支付单号

    private Date paymentTime;           // 付款时间

    private Date DeliverTime;           // 发货时间

    private Date finishTime;            // 成交时间

    private Integer orderStatus;        // 订单状态

    private Date createTime;            // 创建时间

    private Set<OrderDetail> orderDetails;  // 订单详情

}
