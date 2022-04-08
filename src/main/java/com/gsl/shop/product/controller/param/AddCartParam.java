package com.gsl.shop.product.controller.param;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1213:53
 */
@Data
@Accessors(chain = true)
public class AddCartParam {
    private Long uid;
    private Long productId;
    private Integer num;
}
