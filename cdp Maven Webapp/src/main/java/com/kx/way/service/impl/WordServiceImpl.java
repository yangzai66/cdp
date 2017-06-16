package com.kx.way.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.util.DateTimeUtil;
import com.kx.util.JsonUtil;
import com.kx.way.service.IWordService;
@Service("wordService")
public class WordServiceImpl implements IWordService{
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject add(JSONObject dataJson) {
		// TODO Auto-generated method stub
		JSONObject resultJson = JsonUtil.resultData();
		dataJson.put("CREATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
		dataJson.put("UPDATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
		resultJson.put("result", metadataService.execute(metadataService.getsql(dataJson, "word_record")));
		return resultJson;
	}
	@Override
	public JSONObject update(JSONObject dataJson) {
		// TODO Auto-generated method stub
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("result", metadataService.execute(metadataService.getsql(dataJson, "word_record", "word_id", dataJson.getString("word_id"))));
		return resultJson;
	}
	@Override
	public JSONObject list(JSONObject dataJson) {
		// TODO Auto-generated method stub
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("value", metadataService.queryForList("SELECET * FROM WORD_RECORD"));
		return resultJson;
	}
	@Override
	public JSONObject findByCurDate() {
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("data", metadataService.queryForList("SELECT * FROM WORD_RECORD WHERE CREATETIME>'"+DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATE_FORMAT)+" 00:00:00'"));
		return resultJson;
	}

}
