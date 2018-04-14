package com.candy.aku.service.impl;

import com.candy.aku.dao.extend.UserDomainExtendMapper;
import com.candy.aku.dto.UserDto;
import com.candy.aku.model.ResponseModel;
import com.candy.aku.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/3/28 0:52
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public ResponseModel login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
        ResponseModel responseModel = new ResponseModel();
        responseModel.setToken(token);
        responseModel.setMessage("登陆成功");
        return responseModel;
    }
}
