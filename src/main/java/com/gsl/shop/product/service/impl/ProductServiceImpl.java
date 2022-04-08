package com.gsl.shop.product.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gsl.shop.common.NumberUtil;
import com.gsl.shop.product.controller.param.ProductParam;
import com.gsl.shop.product.controller.vo.ProductVo;
import com.gsl.shop.product.entity.Product;
import com.gsl.shop.product.entity.ProductCart;
import com.gsl.shop.product.mapper.ProductCartMapper;
import com.gsl.shop.product.mapper.ProductMapper;
import com.gsl.shop.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1211:10
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductCartMapper productCartMapper;
    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Value("${elasticsearch.index-products}")
    private String index;

    @Override
    @DS("product")
    public IPage<ProductVo> findPage(ProductParam basePage) {
        List<ProductVo> list = new ArrayList<>();
        //当前数据
        Integer current = (basePage.getPage() - 1) * basePage.getPageSize();
        try {
            SearchRequest searchRequest = new SearchRequest(index);
            SearchSourceBuilder query = new SearchSourceBuilder();
            if (StrUtil.isNotBlank(basePage.getProductName())) {
//                query.query(QueryBuilders.fuzzyQuery("productName", basePage.getProductName()));
                query.query(QueryBuilders.matchQuery("productName", basePage.getProductName()).minimumShouldMatch("70%"));
            }
            //分页查询
            query.from(current);
            query.size(basePage.getPageSize());
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            query.highlighter(highlightBuilder.requireFieldMatch(false).field("productName").preTags("<span style='color:red;'>").postTags("</span>"));
            query.sort("productId", SortOrder.ASC);
            searchRequest.source(query);
            SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            //数据遍历出来
            for (SearchHit hit : hits) {
                ProductVo productVo = JSONObject.parseObject(hit.getSourceAsString(), ProductVo.class);
                productVo.setProductNameTitle(productVo.getProductName());
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                if (highlightFields.containsKey("productName")) {
                    productVo.setProductName(highlightFields.get("productName").fragments()[0].toString());
                }
                list.add(productVo);
            }
            if (CollUtil.isNotEmpty(list)) {
                return new Page<ProductVo>()
                        .setTotal(hits.getTotalHits().value)
                        .setSize(basePage.getPageSize())
                        .setCurrent(basePage.getPage())
                        .setRecords(list);
            }
        } catch (Exception e) {
            log.error("Exception e", e);
        }
        return new Page<ProductVo>()
                .setRecords(new ArrayList<>());
    }

    private ProductVo getProductVo(Product product) {
        ProductVo productVo = new ProductVo();
        productVo.setProductId(product.getId().intValue());
        productVo.setProductName(product.getProductName());
        productVo.setProductImgUrl(product.getProductCoverImgUri());
        productVo.setSalePrice(NumberUtil.intToBigDecimal(product.getSalePrice()).doubleValue());
        productVo.setRealPrice(NumberUtil.intToBigDecimal(product.getRealPrice()).doubleValue());
        return productVo;
    }

    @Override
    @DS("product")
    public void addCart(Long uid, Long productId, Integer num) {
        Product product = productMapper.selectById(productId);
        ProductCart cart = productCartMapper.selectOne(Wrappers.lambdaQuery(ProductCart.class)
                .eq(ProductCart::getProductId, productId)
                .eq(ProductCart::getState, 1)
                .eq(ProductCart::getUserId, uid));
        if (product != null) {
            if (cart == null) {
                ProductCart productCart = new ProductCart();
                productCart.setBuyNum(num);
                productCart.setProductId(productId);
                productCart.setUserId(uid);
                productCart.setSalePrice(product.getSalePrice());
                productCart.setRealPrice(product.getRealPrice());
                productCart.setSaleAmount(product.getSalePrice() * num);
                productCart.setRealAmount(product.getRealPrice() * num);
                productCart.setState(1);
                productCart.initTime();
                productCartMapper.insert(productCart);
            } else {
                cart.setUpdateTime();
                cart.setBuyNum(cart.getBuyNum() + num);
                cart.setSaleAmount(product.getSalePrice() * num + cart.getSaleAmount());
                cart.setRealAmount(product.getRealPrice() * num + cart.getRealAmount());
                productCartMapper.updateById(cart);
            }
        }
    }

    @Override
    @DS("product")
    public List<ProductCart> findCartList(Long uid) {
        List<ProductCart> productCarts = productCartMapper.selectList(Wrappers.lambdaQuery(ProductCart.class)
                .eq(ProductCart::getState, 1)
                .eq(ProductCart::getUserId, uid));
        if (CollUtil.isNotEmpty(productCarts)) {
            return productCarts;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    @DS("product")
    public List<Product> findProductList(List<Long> productIds) {
        return productMapper.selectBatchIds(productIds);
    }

    @Override
    @DS("product")
    public Product getProduct(Long productId) {
        return productMapper.selectById(productId);
    }

    @Override
    @DS("product")
    public void addProduct(Product product) {
        product.setProductNo(IdWorker.getMillisecond() + RandomUtil.randomString(5));
        product.initTime();
        productMapper.insert(product);
        addEsDocumentation(product);
    }

    /**
     * 添加Es文档
     * @param product
     */
    private void addEsDocumentation(Product product) {
        try {
            ProductVo productVo = getProductVo(product);
            IndexRequest indexRequest = new IndexRequest(index);
            indexRequest.id(product.getId().toString())
                    .source(JSONObject.toJSONString(productVo), XContentType.JSON);
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            log.info("addProduct create ES status = " + indexResponse.status());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用RestHighLevelClient方式初始化索引文档值(另一种方式ElasticSearchOperations)
     */
    @Override
    @DS("product")
    public void initEsData() {
        List<Product> products = productMapper.selectList(null);
        if (CollUtil.isNotEmpty(products)) {
            products.forEach(product -> addEsDocumentation(product));
        }
    }

    @Override
    @DS("product")
    public Integer getCartCount(Long uid) {
        return productCartMapper.selectCount(Wrappers.lambdaQuery(ProductCart.class).eq(ProductCart::getUserId, uid));
    }

    /**
     * 清除缓存
     */
    @Override
    public void clearEsData() {
        try {
            DeleteRequest deleteRequest = new DeleteRequest(index);
            restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
