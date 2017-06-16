package com.kx.stock.service;

import com.alibaba.fastjson.JSONObject;

public interface IPlateService {
	public JSONObject find(JSONObject dataJson);
	public JSONObject reptileStockByPlate(JSONObject dataJson);
	public JSONObject findPlateStock(JSONObject dataJson);
}	
