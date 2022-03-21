package com.xinyue.app.controller;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("app")
public class AppController {
    @RequestMapping("fallback") // 用于接收网关的熔断失败
    public Object fallback(HttpServletRequest request) {
        JSONObject result = new JSONObject();
        result.put("value", "fallback3");
       Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            result.put(name, request.getHeader(name));
        }
        return result;
    }
}
