package com.gsl.shop.order.service;

import com.gsl.shop.order.entity.OrderInfo;
import com.gsl.shop.product.entity.Product;

import java.util.List;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1214:19
 */
public interface OrderInfoService {
    List<OrderInfo> findList(Long uid);
    void insertOrder(Long uid, Product product);
}
