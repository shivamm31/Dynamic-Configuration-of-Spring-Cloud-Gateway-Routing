package com.xinyue.game.web.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("login")
    public Object login() {
        
        return "login success";
    }
}
