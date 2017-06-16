package com.kx.way.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.controller.CommResult;
import com.kx.way.service.IWordService;
@Controller
@RequestMapping("word")
public class WordController extends CommResult{
	@Autowired
	IWordService wordService;
	@RequestMapping(value="add",method=RequestMethod.POST)
	public void add(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data){
		responseOutWithJson(response, wordService.add(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="/find/today",method=RequestMethod.GET)
	public void findByCurDate(HttpServletRequest request,HttpServletResponse response){
		responseOutWithJson(response, wordService.findByCurDate());
	}
}
