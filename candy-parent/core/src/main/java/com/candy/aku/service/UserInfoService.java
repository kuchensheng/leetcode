package com.candy.aku.service;

import com.candy.aku.domain.UserInfo;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/4/1 20:49
 */
public interface UserInfoService {
    UserInfo findByUserName(String name);
}
