package com.candy.aku.controller;

import com.candy.aku.common.APIResponse;
import com.candy.aku.dto.UserDto;
import com.candy.aku.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/3/28 0:58
 */
@RestController
@RequestMapping("/")
@Api(value = "用户操作控制器",tags = "用户操作控制器")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public APIResponse<String> login(
            @ApiParam(value = "username",name = "用户名",required = true)
            @RequestParam(value = "username",required = true) String username,
            @ApiParam(value = "password",name = "登陆密码",required = true)
            @RequestParam(value = "password",required = true) String password
    ){
        logger.info("登陆");
        return APIResponse.success(userService.login(username,password));
    }
}
