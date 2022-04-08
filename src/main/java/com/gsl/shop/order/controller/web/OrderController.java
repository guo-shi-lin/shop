package com.gsl.shop.order.controller.web;

import cn.hutool.core.collection.CollUtil;
import com.gsl.shop.common.ApiResult;
import com.gsl.shop.common.NumberUtil;
import com.gsl.shop.order.controller.param.CreateOrderParam;
import com.gsl.shop.order.controller.vo.OrderInfoVo;
import com.gsl.shop.order.entity.OrderInfo;
import com.gsl.shop.order.service.OrderInfoService;
import com.gsl.shop.product.entity.Product;
import com.gsl.shop.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1211:14
 */
@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {
    @Resource
    private OrderInfoService orderInfoService;
    @Resource
    private ProductService productService;

    @PostMapping("findList/{uid}")
    public ApiResult<List<OrderInfoVo>> findList(@PathVariable Long uid) {
        List<OrderInfo> list = orderInfoService.findList(uid);
        if (CollUtil.isNotEmpty(list)) {
            List<Long> productIds = list.stream().map(OrderInfo::getProductId).collect(Collectors.toList());
            List<Product> productList = productService.findProductList(productIds);
            Map<Long, Product> productMap = productList.stream().collect(Collectors.toMap(Product::getId, product -> product, (key1, key2) -> key2));
            List<OrderInfoVo> collect = list.stream().map(orderInfo -> {
                Product product = productMap.get(orderInfo.getProductId());
                OrderInfoVo vo = new OrderInfoVo();
                vo.setOrderNo(orderInfo.getOrderNo());
                vo.setBuyNum(orderInfo.getBuyNum());
                vo.setState(orderInfo.getState());
                vo.setProductName(product.getProductName());
                vo.setProductImgUrl(product.getProductCoverImgUri());
                vo.setPayAmount(NumberUtil.amountFormat(orderInfo.getPayAmount()));
                return vo;
            }).collect(Collectors.toList());
            return ApiResult.success(collect);
        }
        return ApiResult.success(new ArrayList<>());
    }

    @PostMapping("createOrder")
    public ApiResult createOrder(@RequestBody CreateOrderParam param) {
        Product product = productService.getProduct(param.getProductId());
        orderInfoService.insertOrder(param.getUid(), product);
        return ApiResult.success();
    }
}
