package com.gsl.shop.product.controller.web;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gsl.shop.common.ApiResult;
import com.gsl.shop.common.BasePage;
import com.gsl.shop.common.NumberUtil;
import com.gsl.shop.product.controller.param.AddCartParam;
import com.gsl.shop.product.controller.param.ProductParam;
import com.gsl.shop.product.controller.vo.ProductCartVo;
import com.gsl.shop.product.controller.vo.ProductVo;
import com.gsl.shop.product.entity.Product;
import com.gsl.shop.product.entity.ProductCart;
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
@RequestMapping("product")
@CrossOrigin
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("findPage")
    public ApiResult<IPage<ProductVo>> findPage(@RequestBody ProductParam param) {
        return ApiResult.success(productService.findPage(param));
    }

    @PostMapping("addCart")
    public ApiResult addCart(@RequestBody AddCartParam param) {
        productService.addCart(param.getUid(), param.getProductId(), param.getNum());
        return ApiResult.success();
    }

    @PostMapping("findCartList/{uid}")
    public ApiResult<List<ProductCartVo>> addCart(@PathVariable Long uid) {
        List<ProductCart> cartList = productService.findCartList(uid);
        if (CollUtil.isNotEmpty(cartList)) {
            List<Long> productIds = cartList.stream().map(ProductCart::getProductId).collect(Collectors.toList());
            List<Product> productList = productService.findProductList(productIds);
            Map<Long, Product> productMap = productList.stream().collect(Collectors.toMap(Product::getId, product -> product, (key1, key2) -> key2));
            List<ProductCartVo> list = cartList.stream().map(productCart -> {
                Product product = productMap.get(productCart.getProductId());
                ProductCartVo vo = new ProductCartVo();
                BeanUtil.copyProperties(productCart, vo);
                vo.setCartId(productCart.getId());
                vo.setRealPrice(NumberUtil.amountFormat(productCart.getRealPrice()));
                vo.setProductName(product.getProductName());
                vo.setProductImgUrl(product.getProductCoverImgUri());
                return vo;
            }).collect(Collectors.toList());
            return ApiResult.success(list);
        }
        return ApiResult.success(new ArrayList<>());
    }

    @PostMapping("addProduct")
    public ApiResult addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ApiResult.success();
    }

    @GetMapping("initEsData")
    public ApiResult initEsData() {
        productService.initEsData();
        return ApiResult.success();
    }

    @GetMapping("getCartCount/{uid}")
    public ApiResult<Integer> getCartCount(@PathVariable Long uid) {
        return ApiResult.success(productService.getCartCount(uid));
    }
}
