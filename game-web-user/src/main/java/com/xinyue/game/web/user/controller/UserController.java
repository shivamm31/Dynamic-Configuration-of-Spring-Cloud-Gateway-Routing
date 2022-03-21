package com.xinyue.game.web.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("getUser")
	public Object getUser() {
		JSONObject user = new JSONObject();
		user.put("name", "www.xinyues.com");
		logger.debug("获取用户信息成功");
		return user;
	}
}
