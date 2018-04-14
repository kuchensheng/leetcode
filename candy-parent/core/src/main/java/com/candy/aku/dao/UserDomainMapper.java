package com.candy.aku.dao;

import com.candy.aku.model.UserDomain;

public interface UserDomainMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    UserDomain selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);
}