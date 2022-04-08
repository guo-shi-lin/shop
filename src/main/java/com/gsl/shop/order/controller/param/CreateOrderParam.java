package com.gsl.shop.order.controller.param;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1214:38
 */
@Data
@Accessors(chain = true)
public class CreateOrderParam {
    private Long uid;
    private Long productId;
}
