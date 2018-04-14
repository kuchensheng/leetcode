package com.candy.aku.dao.extend;

import com.candy.aku.dao.UserDomainMapper;
import com.candy.aku.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/3/28 0:44
 */

@Mapper
public interface UserDomainExtendMapper extends UserDomainMapper {

    public UserDto login(@Param("username") String username,@Param("password") String password);
}
