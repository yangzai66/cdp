package com.kx.stock.service;

import com.alibaba.fastjson.JSONObject;

public interface IStockSpiService {
	public JSONObject list(JSONObject dataJson);
	public JSONObject analyze(JSONObject dataJson);
}
