package com.gsl.shop.user.controller.web;

import com.gsl.shop.common.ApiResult;
import com.gsl.shop.user.controller.param.UserSaveParam;
import com.gsl.shop.user.entity.User;
import com.gsl.shop.user.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1115:12
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("save")
    public ApiResult<User> save(UserSaveParam param) {
        return ApiResult.success(userService.saveUser(param));
    }
}
