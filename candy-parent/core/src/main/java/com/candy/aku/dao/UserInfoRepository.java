package com.candy.aku.dao;

import com.candy.aku.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/4/1 20:47
 */
@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

    UserInfo findByUsername(String username);
}
