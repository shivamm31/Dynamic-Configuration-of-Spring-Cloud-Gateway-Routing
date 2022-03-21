package com.xinyue.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("gateway")
public class FowardRoutingFilterController {
    @RequestMapping("app")
    public String  globalFilters() {
        return "Forward跳转成功";
    }
}
