package com.xinyue.app.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/app")
public class AppController {
    private Logger logger = LoggerFactory.getLogger(AppController.class);
    @PostConstruct
    public void init() {
        System.out.println("===执行init====");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("===销毁bean===");
    }
    @RequestMapping("index")
    public Object test(HttpServletRequest request) {
        String headerValue = request.getHeader("X-Request-Foo");
        logger.info("测试AddRequestHeader GatewayFilter Factory：{}",headerValue);
        JSONObject result = new JSONObject();
        result.put("value", "hello world");
        return result;
    }
    @RequestMapping("add-request-parameter")
    public Object addRequestParameter(@RequestParam String foo) {
        logger.info("addRequestParameter:{}",foo);
        JSONObject result = new JSONObject();
        result.put("value", foo);
        return result;
    }
    @RequestMapping("balance")
    public Object blance() {
        logger.info("balance to this server");
        return "Balance to app-a instance";
    }
    
}
