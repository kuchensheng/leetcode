package com.example.boot.eureka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/6/17 16:53
 */

@RestController
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public List<Map<String,String>> getUser(HttpServletRequest request){
        log.info("request url is "+request.getRequestURL().toString());
        List<Map<String,String>> list = new ArrayList<>();
        for (int i = 0;i< 5;i++){
            Map<String,String> map = new HashMap<>();
            map.put("name"+(i+1),"value"+(i+1));
            map.put("url",request.getRequestURL().toString());
            list.add(map);
        }

        return list;
    }
}
