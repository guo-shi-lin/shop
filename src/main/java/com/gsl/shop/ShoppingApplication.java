package com.gsl.shop;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1110:14
 */
@EnableAsync
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class ShoppingApplication {
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(ShoppingApplication.class, args);
    }
}
