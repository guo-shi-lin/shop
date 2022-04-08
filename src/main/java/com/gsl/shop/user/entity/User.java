package com.gsl.shop.user.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gsl.shop.common.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户表(User)表实体类
 *
 * @author Mr.Wang
 * @version 1.0
 * @since 2022/1/11 13:46
 */
@TableName("user")
@Data
@Accessors(chain = true)
public class User extends BaseEntity {

    /**
     * 用户名称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户密码
     */
    @TableField("user_password")
    private String userPassword;

    /**
     * 用户头像uri
     */
    @TableField("head_img_uri")
    private String headImgUri;

    /**
     * 性别：0-未设置；1-男；2-女；
     */
    @TableField("gender")
    private Integer gender;

    /**
     * 手机号
     */
    @TableField("mobile")
    private String mobile;

    /**
     * 注册时间
     */
    @TableField("register_time")
    private LocalDateTime registerTime;
}