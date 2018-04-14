package com.ssc.candy.mapper;

import com.ssc.candy.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * @Method:查询用户信息列表
     * @Author:Hui
     * @CreateDate:2018/3/4 22:16
     * @param:
     * @return:
     * @exception:
    */
    List<User> selectUserInfo(User user);
}