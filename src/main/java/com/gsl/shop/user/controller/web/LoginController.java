package com.gsl.shop.user.controller.web;

import com.gsl.shop.common.ApiResult;
import com.gsl.shop.user.controller.param.LoginParam;
import com.gsl.shop.user.controller.param.UserSaveParam;
import com.gsl.shop.user.entity.User;
import com.gsl.shop.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gsl
 * @Description:
 * @date 2022/1/1115:12
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class LoginController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public ApiResult<User> login(@RequestBody LoginParam param) {
        return userService.login(param.getNickName(), param.getPassword());
    }
}
