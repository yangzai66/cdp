package com.kx.stock.service.impl;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.service.ICustomStockService;
import com.kx.util.JsonUtil;
@Service("customStockService")
public class CustomStockServiceImpl implements ICustomStockService{
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject stocklist(JSONObject paramsJson) {
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("data", metadataService.queryForList("SELECT * FROM custom_module_stock_relation INNER JOIN STOCK_RECORD ON custom_module_stock_relation.STOCK_NO = STOCK_RECORD.STOCK_NO "+paramsJson.getString("where") +" "+ paramsJson.getString("order")));
		return resultJson;
		
		
		
	}
	@Override
	public JSONObject list() {
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("data", "SELECT * FROM custom_module_stock_relation");
		return resultJson;
	}

}
