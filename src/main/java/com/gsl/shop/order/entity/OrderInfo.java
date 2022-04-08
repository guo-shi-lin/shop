package com.gsl.shop.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.shop.common.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 购物车表实体类
 *
 * @author Mr.Wang
 * @version 1.0
 * @since 2022/1/11 13:46
 */
@TableName("order_info")
@Data
@Accessors(chain = true)
public class OrderInfo extends BaseEntity {

    /**
     * 商品id
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 订单编号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 销售单价(单位分)
     */
    @TableField("buy_num")
    private Integer buyNum;

    /**
     * 销售单价(单位分)
     */
    @TableField("sale_price")
    private Integer salePrice;

    /**
     * 销售价格(单位分)
     */
    @TableField("sale_amount")
    private Integer saleAmount;

    /**
     * 真实单价(单位分)
     */
    @TableField("real_price")
    private Integer realPrice;

    /**
     * 真实价格(单位分)
     */
    @TableField("real_amount")
    private Integer realAmount;

    /**
     * 真实价格(单位分)
     */
    @TableField("pay_amount")
    private Integer payAmount;

    /**
     * 订单状态(0=待支付,1=已支付)
     */
    @TableField("state")
    private Integer state;
}