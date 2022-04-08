package com.gsl.shop.product.controller.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 购物车表实体类
 *
 * @author Mr.Wang
 * @version 1.0
 * @since 2022/1/11 13:46
 */
@Data
@Accessors(chain = true)
public class ProductCartVo {
    /**
     * 购物车id
     */
    private Long cartId;

    /**
     * 商品名字
     */
    private String productName;

    /**
     * 商品图片地址
     */
    private String productImgUrl;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品购买数量
     */
    private Integer buyNum;

    /**
     * 真实单价(单位分)
     */
    private String realPrice;

    /**
     * 状态(0=正常,1=失效)
     */
    private Integer state;
}