package com.kx.way.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.controller.CommResult;
import com.kx.way.service.IPlanService;

@Controller
@RequestMapping("plan")
public class PlanController extends CommResult{
	
	@Autowired
	IPlanService planService;
	@RequestMapping(value="add",method=RequestMethod.POST)
	public void add(HttpServletRequest request,HttpServletResponse response,@Param("data") String data){
		responseOutWithJson(response, planService.add(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public void update(HttpServletRequest request,HttpServletResponse response,@Param("data") String data){
		responseOutWithJson(response, planService.update(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="list",method=RequestMethod.POST)
	public void list(HttpServletRequest request,HttpServletResponse response,@Param("data") String data){
		responseOutWithJson(response, planService.list(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="delete/{id}",method=RequestMethod.GET)
	public void delete(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") String id){
		responseOutWithJson(response, planService.delete(id));
		
	}
	@RequestMapping(value="view/{id}",method=RequestMethod.GET)
	public void planId(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") String id){
		responseOutWithJson(response, planService.planId(id));
	}
	
	
}
