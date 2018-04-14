package com.ssc.candy.dto;

/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/27 22:47
 */

public class UserDto {
    private Integer userid;
    private String username;
    private String phone;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
