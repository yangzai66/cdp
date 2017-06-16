package com.kx.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.controller.CommResult;
import com.kx.stock.service.IStockService;
import com.kx.util.ST;

@Controller
@RequestMapping("/stock")
public class StockController extends CommResult {
	@Autowired
	IStockService stockService;
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public void find(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data){
		System.out.println("1231");
		responseOutWithJson(response, stockService.find(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="/cache/list",method=RequestMethod.GET)
	public void cachelist(HttpServletRequest request,HttpServletResponse response){
		responseOutWithJson(response, ST.allStock);
	}
	@RequestMapping(value="/reptilePlate",method=RequestMethod.POST)
	public void reptilePlate(HttpServletRequest request,HttpServletResponse response){
		stockService.reptilePlate();
	}
	@RequestMapping(value="/view/{stock_no}",method = RequestMethod.GET)
	public void details(HttpServletRequest request,HttpServletResponse response,@PathVariable String stock_no){
		responseOutWithJson(response, stockService.details(stock_no));
	}
}
