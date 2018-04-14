package com.candy.aku.model;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/4/14 23:13
 */
public class ResponseModel {
    private UsernamePasswordToken token;
    private String message;

    public UsernamePasswordToken getToken() {
        return token;
    }

    public void setToken(UsernamePasswordToken token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
