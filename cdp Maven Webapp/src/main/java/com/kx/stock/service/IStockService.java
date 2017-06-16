package com.kx.stock.service;

import com.alibaba.fastjson.JSONObject;

public interface IStockService {
	public JSONObject find(JSONObject dataJson);
	public JSONObject reptilePlate();
	public JSONObject details(String stock_no);
}
