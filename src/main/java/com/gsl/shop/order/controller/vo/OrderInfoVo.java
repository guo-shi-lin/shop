package com.gsl.shop.order.controller.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1215:41
 */
@Data
@Accessors(chain = true)
public class OrderInfoVo {
    /**
     * 商品名字
     */
    private String productName;

    /**
     * 商品图片地址
     */
    private String productImgUrl;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 购买数量
     */
    private Integer buyNum;

    /**
     * 支付金额
     */
    private String payAmount;

    /**
     * 订单状态(0=待支付,1=已支付)
     */
    private Integer state;
}
