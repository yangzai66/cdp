package com.kx.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.controller.CommResult;
import com.kx.stock.service.IPlateService;

@Controller
@RequestMapping("/plate")
public class PlateController extends CommResult {
	@Autowired
	IPlateService plateService;
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public void find(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data){
	responseOutWithJson(response, plateService.find(JSONObject.parseObject(data)));
		//System.out.println(JSONObject.parseObject(data).toJSONString());
	}
	@RequestMapping(value="/reptile/stock",method=RequestMethod.POST)
	public void reptileStock(HttpServletRequest request,HttpServletResponse response){
		responseOutWithJson(response, plateService.reptileStockByPlate(null));
	}
	@RequestMapping(value="/stock/list",method=RequestMethod.POST)
	public void findPlateStock(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data){
		System.out.println(123456);
		responseOutWithJson(response, plateService.findPlateStock(JSONObject.parseObject(data)));
	}
}
