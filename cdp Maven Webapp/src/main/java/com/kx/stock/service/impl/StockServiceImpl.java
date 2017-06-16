package com.kx.stock.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.service.IStockService;
import com.kx.util.HttpClient;
import com.kx.util.JsonUtil;
@Service("stockService")
public class StockServiceImpl implements IStockService {
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject find(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
		String sql = "SELECT * FROM STOCK_RECORD WHERE 1=1 ";
		if(dataJson.containsKey("stock_no")&&!dataJson.getString("stock_no").isEmpty()){
			sql+=" AND STOCK_NO='"+dataJson.getString("stock_no")+"' ";
		}
		System.out.println(sql+dataJson.getString("order")+"  limit "+((dataJson.getIntValue("page_no")-1)*dataJson.getIntValue("page_size"))+","+(dataJson.getIntValue("page_no")*dataJson.getIntValue("page_size")));
		resultJson.put("data", metadataService.queryForList(sql+dataJson.getString("order")+"  limit "+((dataJson.getIntValue("page_no")-1)*dataJson.getIntValue("page_size"))+","+(dataJson.getIntValue("page_no")*dataJson.getIntValue("page_size"))));
		int total_page = metadataService.queryForInt(sql.replaceAll("[*]", "count(*)"))/dataJson.getIntValue("page_size");
		resultJson.put("count", total_page%dataJson.getIntValue("page_size")==0?total_page:total_page+1);
		resultJson.put("page_no", dataJson.getIntValue("page_no"));
		resultJson.put("page_size", dataJson.getIntValue("page_size"));
		return resultJson;
	}
	public JSONObject reptilePlate(){
		HttpClient httpClient = new HttpClient();
		String content = httpClient.httpGet("http://stock.gtimg.cn/data/view/bdrank.php?&t=01/averatio&p=1&o=0&l=80&v=list_data", "utf-8");
		content = content.substring(content.indexOf("data:'")+6,content.lastIndexOf("'"));
		for(String plate:content.split(",")){
			JSONObject plateJson = new JSONObject();
			plateJson.put("SEQNO", metadataService.getPrimaryValue("plate_record"));
			plateJson.put("PLATE_NO", plate.replaceAll("bkqt", ""));
			metadataService.execute(metadataService.getsql(plateJson, "plate_record"));
		}
		return null;
	}
	@Override
	public JSONObject details(String stock_no) {
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("data", metadataService.queryForMap("SELECT * FROM STOCK_RECORD WHERE STOCK_NO='"+stock_no+"'"));
		return resultJson;
	}

}
