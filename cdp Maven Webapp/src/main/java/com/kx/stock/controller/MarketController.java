package com.kx.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kx.metadata.controller.CommResult;
import com.kx.util.ST;

@Controller
@RequestMapping("market")
public class MarketController extends CommResult {
	@RequestMapping(value="/list")
	public void list(HttpServletRequest request,HttpServletResponse response){
		responseOutWithJson(response, ST.marketJson);
	}
}
