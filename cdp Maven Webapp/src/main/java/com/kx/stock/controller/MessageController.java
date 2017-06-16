package com.kx.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kx.metadata.controller.CommResult;
import com.kx.stock.service.IMessageService;

@Controller
@RequestMapping("message")
public class MessageController extends CommResult {
	@Autowired
	IMessageService messageService;
	@RequestMapping(value="/list/{id}")
	public void list(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
		responseOutWithJson(response, messageService.list(id));
	}
}
