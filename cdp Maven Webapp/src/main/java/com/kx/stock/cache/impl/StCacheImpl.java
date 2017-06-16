package com.kx.stock.cache.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.cache.IStCache;
import com.kx.util.ST;
@Service("stCache")
public class StCacheImpl implements IStCache{
	@Autowired
	IMetadataService metadataService;
	public void loadCache(){
		ST.allStock=loadAllStock();
		ST.marketJson =loadMarket();
		ST.industryPlateJson = loadPlate();
	}
	public JSONObject loadPlate(){
		JSONObject jsonbJson =  new JSONObject();
		List<Map<String, Object>> list = metadataService.queryForList("SELECT * FROM plate_record");
		for(Map<String,Object> map:list){
			JSONObject marketJson = (JSONObject)JSONObject.toJSON(map);
			jsonbJson.put(map.get("PLATE_NO").toString(), marketJson);
		}
		return jsonbJson;
	}
	public JSONObject loadMarket(){
		JSONObject jsonbJson =  new JSONObject();
		List<Map<String, Object>> list = metadataService.queryForList("SELECT * FROM market_record");
		for(Map<String,Object> map:list){
			JSONObject marketJson = (JSONObject)JSONObject.toJSON(map);
			jsonbJson.put(map.get("STOCK_NO_BUFF").toString(), marketJson);
		}
		return jsonbJson;
	}
	public JSONObject loadAllStock(){
		JSONObject jsonbJson =  new JSONObject();
		List<Map<String, Object>> list = metadataService.queryForList("SELECT * from stock_record");
		for(Map<String, Object> map:list){
			JSONObject stockJson = (JSONObject)JSONObject.toJSON(map);
			jsonbJson.put(map.get("STOCK_NO_BUFF").toString(), stockJson);
		}
		return jsonbJson;
	}
}
