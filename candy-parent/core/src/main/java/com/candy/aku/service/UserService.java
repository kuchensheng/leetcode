package com.candy.aku.service;

import com.candy.aku.dto.UserDto;
import com.candy.aku.model.ResponseModel;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/3/28 0:51
 */
public interface UserService {
    ResponseModel login(String username, String password);
}
