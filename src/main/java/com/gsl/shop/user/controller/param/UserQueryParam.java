package com.gsl.shop.user.controller.param;

import com.gsl.shop.common.BasePage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 用户查询参数
 *
 * @author Mr.Wang
 * @version 1.0
 * @since 2022/1/11 13:46
 */
@Data
@Accessors(chain = true)
public class UserQueryParam extends BasePage {

    /**
     * 用户名称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 注册开始时间
     */
    private String registerStartTime;

    /**
     * 注册结束时间
     */
    private String registerEndTime;
}