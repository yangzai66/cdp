package com.kx.stock.service;
import com.alibaba.fastjson.JSONObject;

public interface IStockHistoryService {
	public JSONObject list(JSONObject paramsJson);
}
