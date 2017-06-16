package com.kx.stock.controller;

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
import com.kx.stock.service.ICustomStockService;

@Controller
@RequestMapping("stock/custom")
public class CustomStockController extends CommResult{
	@Autowired
	ICustomStockService customStockService;
	@RequestMapping(value="/view",method=RequestMethod.POST)
	public void view(HttpServletRequest request,HttpServletResponse response,@Param("data") String data){
		responseOutWithJson(response, customStockService.stocklist(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="/list")
	public void list(HttpServletRequest request,HttpServletResponse response){
		responseOutWithJson(response, customStockService.list());
	}
}
