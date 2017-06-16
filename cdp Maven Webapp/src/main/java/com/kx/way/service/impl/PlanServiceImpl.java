package com.kx.way.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.util.CDP;
import com.kx.util.DateTimeUtil;
import com.kx.util.JsonUtil;
import com.kx.way.service.IPlanService;
@Service("planService")
public class PlanServiceImpl implements IPlanService{

	@Autowired
	IMetadataService metadataService;
	
	@Override
	public JSONObject add(JSONObject paramsJson) {
		JSONObject resultJson = JsonUtil.resultData();
		paramsJson.put("PLAN_DATE", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
		resultJson.put("result", metadataService.execute(metadataService.getsql(paramsJson, "plan_record")));
		return resultJson;
	}

	@Override
	public JSONObject update(JSONObject paramsJson) {
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("result", metadataService.execute(metadataService.getsql(paramsJson, "plan_record","PLAN_ID",paramsJson.getString("PLAN_ID"))));
		return resultJson;
	}

	@Override
	public JSONObject list(JSONObject paramsJson) {
		JSONObject resultJson = JsonUtil.resultData();
		String sql = "SELECT * FROM PLAN_RECORD WHERE 1=1 ";
		if(paramsJson.containsKey("starttime") && StringUtils.isNotEmpty(paramsJson.getString("starttime"))){
			sql += " AND PLAN_DATE > '"+paramsJson.getString("starttime")+"'";
		}
		if(paramsJson.containsKey("endtime") && StringUtils.isNotEmpty(paramsJson.getString("endtime"))){
			sql += " AND PLAN_DATE < '"+paramsJson.getString("endtime")+"'";
		}
		resultJson.put("data", metadataService.queryForList(sql));
		return resultJson;
	}

	@Override
	public JSONObject delete(String id) {
		JSONObject resultJson = JsonUtil.resultData();
				String sql = "DELETE FROM PLAN_RECORD WHERE PLAN_ID='"+id+"'";
				metadataService.execute(sql);
		return resultJson;
	}

	@Override
	public JSONObject planId(String id) {
		JSONObject resultJson = JsonUtil.resultData();
		Map<String, Object> dataMap = metadataService.queryForMap("SELECT * FROM PLAN_RECORD WHERE PLAN_ID='"+id+"'");
		if(dataMap==null){
			resultJson.put("result", false);
			resultJson.put("msg", "没有该条件数据、{id="+id+"}");
			return resultJson;
		}
		resultJson.put("data", dataMap);
		return resultJson;
	}

}
