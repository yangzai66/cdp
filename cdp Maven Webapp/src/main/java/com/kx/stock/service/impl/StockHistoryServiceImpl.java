package com.kx.stock.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.service.IStockHistoryService;
import com.kx.util.JsonUtil;
@Service("stockHistorySerivce")
public class StockHistoryServiceImpl implements IStockHistoryService{
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject list(JSONObject paramsJson) {
		JSONObject resultJson = JsonUtil.resultData();
		String sql = "SELECT * FROM STOCK_RECORD_H WHERE 1=1";
		if(paramsJson.containsKey("stock_no") && StringUtils.isNotEmpty(paramsJson.getString("stock_no"))){
			sql += " STOCK_NO='"+paramsJson.getString("stock_no")+"'";
		}
		if(paramsJson.containsKey("starttime") && StringUtils.isNotEmpty(paramsJson.getString("starttime"))){
			sql+= " CREATETIME >= '"+paramsJson.getString("starttime")+"'";
		}
		if(paramsJson.containsKey("endtime") && StringUtils.isNotEmpty(paramsJson.getString("endtime"))){
			sql+= " CREATETIME < '"+paramsJson.getString("endtime")+"'";
		}
		if(paramsJson.containsKey("createtime") && StringUtils.isNotEmpty(paramsJson.getString("createtime"))){
			sql+=" CREATETIME = '"+paramsJson.getString("createtime")+"'";
		}
		
		return null;
	}

}
