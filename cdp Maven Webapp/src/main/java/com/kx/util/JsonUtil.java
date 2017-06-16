package com.kx.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	public static JSONObject resultData(boolean b,int type,String msg,String data){
		JSONObject resultJSON = new JSONObject();
		resultJSON.put("result", b);
		resultJSON.put("type", type);
		resultJSON.put("msg", msg);
		resultJSON.put("data", data);
		resultJSON.put("status", 200);
		return resultJSON;
	}
	public static JSONObject resultData(){
		JSONObject resultJSON = new JSONObject();
		resultJSON.put("result", true);
		resultJSON.put("type", 0);
		resultJSON.put("msg", "");
		resultJSON.put("data", "");
		resultJSON.put("status", 200);
		return resultJSON;
	}
}
