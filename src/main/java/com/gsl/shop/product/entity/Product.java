package com.gsl.shop.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.shop.common.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 商品表实体类
 *
 * @author Mr.Wang
 * @version 1.0
 * @since 2022/1/11 13:46
 */
@TableName("product")
@Data
@Accessors(chain = true)
public class Product extends BaseEntity {

    /**
     * 商品名称
     */
    @TableField("product_name")
    private String productName;

    /**
     * 商品编码
     */
    @TableField("product_no")
    private String productNo;

    /**
     * 商品封面图片
     */
    @TableField("product_cover_img_uri")
    private String productCoverImgUri;

    /**
     * 商品销售价格(单位分)
     */
    @TableField("sale_price")
    private Integer salePrice;

    /**
     * 商品真实价格(单位分)
     */
    @TableField("real_price")
    private Integer realPrice;

    /**
     * 商品介绍
     */
    @TableField("product_introduce")
    private String productIntroduce;
}