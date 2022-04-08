package com.gsl.shop.product.controller.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 购物车表实体类
 *
 * @author Mr.Wang
 * @version 1.0
 * @since 2022/1/11 13:46
 */
@Data
@Accessors(chain = true)
public class ProductVo implements Serializable {
    /**
     * 商品id
     */
    @Id
    private Integer productId;

    /**
     * 商品名字
     */
    private String productName;

    /**
     * 商品名字
     */
    private String productNameTitle;

    /**
     * 商品图片地址
     */
    private String productImgUrl;

    /**
     * 真实单价(单位分)
     */
    private Double realPrice;

    /**
     * 销售单价(单位分)
     */
    private Double salePrice;

}