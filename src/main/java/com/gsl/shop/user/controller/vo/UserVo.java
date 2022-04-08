package com.gsl.shop.user.controller.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author gsl
 * @Description: 用户查询
 * @date 2022/1/1114:53
 */
@Data
@Accessors(chain = true)
public class UserVo {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户头像uri
     */
    private String headImgUri;

    /**
     * 性别：0-未设置；1-男；2-女；
     */
    private Integer gender;

    /**
     * 注册时间
     */
    private String registerTime;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;
}
