package com.ssc.candy.service.impl;

import com.ssc.candy.common.CandyException;
import com.ssc.candy.common.Errors;
import com.ssc.candy.mapper.UserMapper;
import com.ssc.candy.model.User;
import com.ssc.candy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/4 22:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper dao;

    @Override
    public User login(User user) {
        List<User> users = this.dao.selectUserInfo(user);
        if(null == users || users.size() == 0)
            throw CandyException.withErrorCode(Errors.System.NULLPOINT);
        if(null != users && users.size() > 0)
        return users.get(0);
        return null;
    }
}
