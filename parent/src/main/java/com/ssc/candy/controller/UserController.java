package com.ssc.candy.controller;

import com.ssc.candy.common.APIResponse;
import com.ssc.candy.model.User;
import com.ssc.candy.service.UserService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/4 22:23
 */
@RestController
@RequestMapping(value = "/user")
@Api("用户操作相关APIs")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录",notes = "用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public APIResponse<User> login(
            @ApiParam(name = "username",required = true,value = "用户名")
            @RequestParam(value = "username",required = true) String username,
            @ApiParam(name = "password",required = true,value = "登录密码")
            @RequestParam(value = "password",required = true) String password){
        logger.info("登陆信息:用户名：{}，密码：{}",username,password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return new APIResponse<>().success(this.userService.login(user));
    }
}
