package com.candy.aku.common;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/4/14 22:51
 */
public class APIResponse<T> {
    private static final String SUCCESS_CODE="success";
    private String code;
    private T data;
    private String message;

    public APIResponse(String code) {
        this.code = code;
    }

    public APIResponse() {
    }

    public APIResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public APIResponse(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static  APIResponse success(){
        return new APIResponse(SUCCESS_CODE);
    }

    public static <T> APIResponse success(T data){
        return new APIResponse(SUCCESS_CODE,data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
