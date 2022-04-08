package com.gsl.shop.common;

import lombok.Data;

/**
 * @author gsl
 * @Description: 基础分页参数
 * @date 2022/1/1114:49
 */
@Data
public class BasePage {
    /**
     * 页次 1
     */
    protected Integer page;

    /**
     * 每页显示数 10
     */
    protected Integer pageSize;
}
