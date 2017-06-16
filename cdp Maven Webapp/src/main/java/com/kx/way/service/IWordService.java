package com.kx.way.service;

import com.alibaba.fastjson.JSONObject;

public interface IWordService {
	public JSONObject add(JSONObject dataJson);
	public JSONObject update(JSONObject dataJson);
	public JSONObject list(JSONObject dataJson);
	public JSONObject findByCurDate();
}
