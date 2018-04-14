package com.ssc.candy.common;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/6 21:26
 */

@RestControllerAdvice
@Api("异常处理")
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public APIResponse errorHandler(CandyException e) {
        APIResponse apiResponse = new APIResponse();
//        apiResponse.setCode(e.getCode());
//        apiResponse.setMessage("API调用异常");
//        apiResponse.setData(e.getThrowable().getCause());getCause
        return apiResponse.fail(e);
    }
}
