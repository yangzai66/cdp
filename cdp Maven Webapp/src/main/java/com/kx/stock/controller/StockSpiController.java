package com.kx.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.controller.CommResult;
import com.kx.stock.service.IStockSpiService;

@Controller
@RequestMapping("stockSpi")
public class StockSpiController extends CommResult{
	@Autowired
	IStockSpiService stockSpiService;
	@RequestMapping("/analyze")
	public void analyze(HttpServletRequest request,HttpServletResponse response){
		responseOutWithJson(response, stockSpiService.analyze(null));
	}
	@RequestMapping("/list")
	public void list(HttpServletRequest request,HttpServletResponse response,@Param("data") String data){
		responseOutWithJson(response, stockSpiService.list(JSONObject.parseObject(data)));
	}
}
