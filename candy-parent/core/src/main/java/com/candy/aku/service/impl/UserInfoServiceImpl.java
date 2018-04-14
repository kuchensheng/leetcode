package com.candy.aku.service.impl;

import com.candy.aku.dao.UserInfoRepository;
import com.candy.aku.domain.UserInfo;
import com.candy.aku.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/4/1 20:49
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Transactional(readOnly = true)
    @Override
    public UserInfo findByUserName(String name) {
        return userInfoRepository.findByUsername(name);
    }
}
