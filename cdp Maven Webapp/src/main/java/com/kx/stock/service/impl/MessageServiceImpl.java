package com.kx.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.service.IMessageService;
import com.kx.util.JsonUtil;
@Service("messageService")
public class MessageServiceImpl implements IMessageService {
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject list(String id) {
		JSONObject dataJson = JsonUtil.resultData();
		System.out.println("select * from message_record where seqno > '"+id+"' limit 0,200");
		dataJson.put("data", metadataService.queryForList("select * from message_record where seqno > '"+id+"' limit 0,200"));
		return dataJson;
	}

}
