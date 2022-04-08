package com.gsl.shop.user.controller.param;

import com.gsl.shop.common.BasePage;
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
public class UserSaveParam {

    /**
     * 用户名称
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 性别：0-未设置；1-男；2-女；
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String mobile;
}