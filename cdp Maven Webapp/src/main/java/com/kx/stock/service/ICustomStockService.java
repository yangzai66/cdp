package com.kx.stock.service;

import com.alibaba.fastjson.JSONObject;

public interface ICustomStockService {
	public JSONObject stocklist(JSONObject paramsJson);
	public JSONObject list();
}
