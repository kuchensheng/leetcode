package com.ssc.candy.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.xml.stream.Location;

/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/6 21:32
 */

@Component
@ConfigurationProperties(prefix = "candy.exception")
@PropertySource("classpath:exception.properties")
public class CandyException extends RuntimeException {

    private Integer code;
    private String codeDesc;
    private String errorMessage;
    private Throwable throwable;

   public CandyException(){
       super();
   }
   public CandyException(Integer code){
       super();
       this.code = code;
   }

   public CandyException(String codeDesc){
       super();
       this.codeDesc = codeDesc;
   }
   public CandyException(String codeDesc,Throwable throwable){
       super();
       this.throwable = throwable;
       this.codeDesc = codeDesc;
   }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public static CandyException withErrorCode(Integer code){
        return new CandyException(code);
    }
    public static CandyException withErrorCode(String codeDesc){
        return  new CandyException(codeDesc);
    }
}
