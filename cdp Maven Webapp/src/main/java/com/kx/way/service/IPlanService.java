package com.kx.way.service;

import com.alibaba.fastjson.JSONObject;

public interface IPlanService {
	public JSONObject add(JSONObject paramsJson);
	public JSONObject update(JSONObject paramsJson);
	public JSONObject list(JSONObject paramsJson);
	public JSONObject delete(String id);
	public JSONObject planId(String id);
}
