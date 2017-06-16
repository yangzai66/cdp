package com.kx.way.service;

import com.alibaba.fastjson.JSONObject;
import com.kx.way.model.Note;

public interface INoteService {
	public JSONObject add(Note note);
	public JSONObject update(JSONObject dataJson);
	public JSONObject list(JSONObject dataJson);
	public JSONObject delete(JSONObject dataJson);
	public JSONObject view(String id);
}
