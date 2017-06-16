package com.kx.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.controller.CommResult;
import com.kx.sys.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController extends CommResult{
	@Autowired
	IUserService userService;
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data) {
		responseOutWithJson(response, userService.login(JSONObject.parseObject(data)));
	}
}
