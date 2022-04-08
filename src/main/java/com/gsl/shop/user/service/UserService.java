package com.gsl.shop.user.service;

import com.gsl.shop.common.ApiResult;
import com.gsl.shop.user.controller.param.UserSaveParam;
import com.gsl.shop.user.entity.User;

/**
* 用户表(User)表服务类
*
* @author Mr.Wang
* @version 1.0
* @since 2022/1/11 13:46
*/
public interface UserService{
    /**
     * 用户登录
     * @param nickName 用户名
     * @param password 用户密码
     * @return
     */
    ApiResult<User> login(String nickName, String password);

    /**
     * 添加用户
     * @param param
     */
    User saveUser(UserSaveParam param);
    /**
     * 用户退出
     * @param uid 用户id
     * @return
     */
    void logout(Long uid);
}