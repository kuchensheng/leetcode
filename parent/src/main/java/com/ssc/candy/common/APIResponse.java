package com.ssc.candy.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/4 23:17
 */
public class APIResponse<T> {
    private static final Integer SUCCESS_CODE = 200;
    private static final Integer FAIL_CODE = 400;

    private T data;
    private Integer code;
    private String message;

    private static final String MESSAGE_SUCCESS = "API调用成功";
    private static final String MESSAGE_FAIL = "API调用失败";

    public APIResponse() {
    }

    public APIResponse(T data) {
        this.data = data;
    }

    public APIResponse success(T data){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(SUCCESS_CODE);
        apiResponse.setMessage(MESSAGE_SUCCESS);
        apiResponse.setData(data);
        return  apiResponse;
    }

    public APIResponse fail(T message){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setCode(FAIL_CODE);
        apiResponse.setMessage(MESSAGE_FAIL);
        apiResponse.setData(data);
        return  apiResponse;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
