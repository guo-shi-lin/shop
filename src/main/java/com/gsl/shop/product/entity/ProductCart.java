package com.gsl.shop.product.entity;

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
@TableName("product_cart")
@Data
@Accessors(chain = true)
public class ProductCart extends BaseEntity {

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
     * 商品购买数量
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
     * 状态(0=正常,1=失效)
     */
    @TableField("state")
    private Integer state;
}