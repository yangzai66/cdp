package com.kx.stock.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.service.IPlateService;
import com.kx.util.HttpClient;
import com.kx.util.JsonUtil;
@Service("plateService")
public class PlateServiceImpl implements IPlateService{
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject find(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("data",metadataService.queryForList("SELECT * FROM PLATE_RECORD "+dataJson.getString("order")));
		return resultJson;
	}
	@Override
	public JSONObject reptileStockByPlate(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
		HttpClient httpClient = new HttpClient();
		try {
			List<Map<String, Object>>  plateList = metadataService.queryForList("SELECT PLATE_NO FROM PLATE_RECORD");
			for(Map<String, Object> plateMap:plateList){
				String content = httpClient.httpGet("http://stock.gtimg.cn/data/index.php?appn=rank&t=pt"+plateMap.get("PLATE_NO")+"/chr&p=1&o=0&l=200&v=list_data", "");
				content = content.substring(content.indexOf("data:'")+6,content.lastIndexOf("'"));
				for(String stock:content.split(",")){
					JSONObject plate_stock_relation = new JSONObject();
					plate_stock_relation.put("SEQNO", metadataService.getPrimaryValue("plate_stock_relation"));
					plate_stock_relation.put("PLATE_NO", plateMap.get("PLATE_NO"));
					plate_stock_relation.put("STOCK_NO", stock);
					metadataService.execute(metadataService.getsql(plate_stock_relation, "plate_stock_relation"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultJson;
	}
	@Override
	public JSONObject findPlateStock(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
		resultJson.put("data", metadataService.queryForList("SELECT * FROM STOCK_RECORD WHERE STOCK_NO_BUFF IN (SELECT STOCK_NO FROM PLATE_STOCK_RELATION WHERE PLATE_NO='"+dataJson.getString("plate_no")+"') "+dataJson.getString("order")));
		return resultJson;
	}

}
