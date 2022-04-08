package com.gsl.shop.user.controller.param;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户查询参数
 *
 * @author Mr.Wang
 * @version 1.0
 * @since 2022/1/11 13:46
 */
@Data
@Accessors(chain = true)
public class LoginParam{

    /**
     * 用户名称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String password;

}