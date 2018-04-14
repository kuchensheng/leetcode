package com.ssc.candy.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/4 22:35
 */
public class HTTPUtil {
    /**
     * @Method:获取客户端真实IP地址
     * @Author:Hui
     * @CreateDate:2018/3/4 22:35
     * @param:
     * @return:
     * @exception:
    */

    private Logger logger = LoggerFactory.getLogger(HTTPUtil.class);

    public static String getIpAddr(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");
        return ip;

    }
}
