package com.gsl.shop.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gsl.shop.product.controller.param.ProductParam;
import com.gsl.shop.product.controller.vo.ProductVo;
import com.gsl.shop.product.entity.Product;
import com.gsl.shop.product.entity.ProductCart;

import java.util.List;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1211:00
 */
public interface ProductService {
    /**
     * 分页查询商品
     * @param page
     * @return
     */
    IPage<ProductVo> findPage(ProductParam page);

    /**
     * 添加到购物车
     * @param uid
     * @param productId
     * @param num
     */
    void addCart(Long uid, Long productId, Integer num);

    /**
     * 根据用户获取购物车数据
     * @param uid
     * @return
     */
    List<ProductCart> findCartList(Long uid);

    /**
     * 根据商品ids查找数据
     * @param productIds
     * @return
     */
    List<Product> findProductList(List<Long> productIds);

    /**
     * 根据商品id获取数据
     * @param productId
     * @return
     */
    Product getProduct(Long productId);

    /**
     * 添加商品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 用RestHighLevelClient方式初始化索引文档值(另一种方式ElasticSearchOperations)
     */
    void initEsData();

    /**
     * 获取用户购物车数量
     * @param uid
     * @return
     */
    Integer getCartCount(Long uid);

    void clearEsData();
}
