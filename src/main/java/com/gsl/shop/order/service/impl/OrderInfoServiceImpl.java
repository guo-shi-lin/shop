package com.gsl.shop.order.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gsl.shop.order.entity.OrderInfo;
import com.gsl.shop.order.mapper.OrderInfoMapper;
import com.gsl.shop.order.service.OrderInfoService;
import com.gsl.shop.product.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1214:21
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    @DS("order")
    public List<OrderInfo> findList(Long uid) {
        List<OrderInfo> orderInfos = orderInfoMapper.selectList(Wrappers.lambdaQuery(OrderInfo.class).eq(OrderInfo::getUserId, uid));
        return CollUtil.isNotEmpty(orderInfos) ? orderInfos : new ArrayList<>();
    }

    @Override
    @DS("order")
    public void insertOrder(Long uid, Product product) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.initTime();
        orderInfo.setUserId(uid);
        orderInfo.setState(1);
        orderInfo.setBuyNum(1);
        orderInfo.setOrderNo(IdWorker.getMillisecond());
        orderInfo.setProductId(product.getId());
        orderInfo.setSalePrice(product.getSalePrice());
        orderInfo.setSaleAmount(product.getSalePrice());
        orderInfo.setRealAmount(product.getRealPrice());
        orderInfo.setRealPrice(product.getRealPrice());
        orderInfo.setPayAmount(orderInfo.getRealAmount());
        orderInfoMapper.insert(orderInfo);
    }
}
