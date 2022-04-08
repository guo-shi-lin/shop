package com.gsl.shop.user.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gsl.shop.common.ApiResult;
import com.gsl.shop.common.ApiResultFailEnum;
import com.gsl.shop.user.controller.param.UserSaveParam;
import com.gsl.shop.user.controller.vo.UserVo;
import com.gsl.shop.user.entity.User;
import com.gsl.shop.user.mapper.UserMapper;
import com.gsl.shop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
* 用户表(User)表服务实现类
*
* @author Mr.Wang
* @version 1.0
* @since 2022/1/11 13:46
*/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 用户表Mapper
     */
    @Resource
    private UserMapper userMapper;


    @Override
    public ApiResult<User> login(String nickName, String password) {
        if (StrUtil.isBlank(nickName) || StrUtil.isBlank(password)) {
            return ApiResult.fail(ApiResultFailEnum.CLIENT_REQ_PARAM_REQUIRED_EMPTY, ApiResultFailEnum.CLIENT_REQ_PARAM_REQUIRED_EMPTY.getMsg());
        }
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class)
                .eq(User::getNickName, nickName));
        if (user == null) {
            return ApiResult.fail(ApiResultFailEnum.CLIENT_LOGIN_USER_NOT_FOUND, ApiResultFailEnum.CLIENT_LOGIN_USER_NOT_FOUND.getMsg());
        }
        if (!user.getUserPassword().equals(password)) {
            return ApiResult.fail(ApiResultFailEnum.CLIENT_LOGIN_PASSWORD_WRONG, ApiResultFailEnum.CLIENT_LOGIN_PASSWORD_WRONG.getMsg());
        }
        return ApiResult.success(user);
    }

    @Override
    public User saveUser(UserSaveParam param) {
        User user = new User();
        user.setGender(param.getGender());
        user.setMobile(param.getMobile());
        user.setNickName(param.getNickName());
        user.setUserPassword(param.getPassword());
        user.setRegisterTime(LocalDateTime.now());
        user.initTime();
        userMapper.insert(user);
        return user;
    }


    @Override
    public void logout(Long uid) {

    }
}