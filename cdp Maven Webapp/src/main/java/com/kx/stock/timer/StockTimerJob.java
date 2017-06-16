package com.kx.stock.timer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.util.HttpClient;
import com.kx.util.JsonUtil;

@Component
public class StockTimerJob	 {
	private Log log = LogFactory.getLog(StockTimerJob.class);
	@Autowired
	IMetadataService metadataService;
	 @Scheduled(cron="0 57 07 * * ?")
	 public  void saveStockHistory(){
			JSONObject resultJson = JsonUtil.resultData();
			log.info("start back stock data!");
			List<Map<String, Object>> stockList = metadataService.queryForList("SELECT * FROM STOCK_RECORD");
			for(Map<String, Object> map:stockList){
				JSONObject stockJson = (JSONObject)JSONObject.toJSON(map);
				Map<String, Object> stock_h = metadataService.queryForMap("SELECT * FROM STOCK_RECORD_H WHERE STOCK_NO='"+stockJson.getString("STOCK_NO")+"' AND CREATETIME='"+stockJson.getString("CREATETIME")+"'");
				
				if(null==stock_h || stock_h.isEmpty()){
					stockJson.remove("SEQNO");
					metadataService.execute(metadataService.getsql(stockJson, "stock_record_h"));
				}else{
					stockJson.put("SEQNO", stock_h.get("SEQNO"));
					metadataService.execute(metadataService.getsql(stockJson, "stock_record_h", "SEQNO", stock_h.get("SEQNO").toString()));
				}
				
			}
			log.info("back stock data! is ok!");
			System.out.println("backup is ok!");
//		  int tradeCount = metadataService.queryForInt("SELECT COUNT(*) FROM TRADE_DETAIL_RECORD");
//		  log.info("back stock trade detail data! num="+tradeCount);
//		  int pageSize = 1000;
//		  int totalPage = tradeCount/pageSize;
//		  if(totalPage%pageSize!=0){
//			  totalPage+=1;
//		  }
//		  for(int i=1;i<=pageSize;i++){
//			  List<Map<String, Object>> tradeList = metadataService.queryForList("SELECT * FROM TRADE_DETAIL_RECORD LIMIT "+(i-1)*pageSize+","+pageSize);
//			  List<String> sqls = new ArrayList<String>();
//			  for(Map<String, Object> tradeMap:tradeList){
//				  sqls.add(metadataService.getsql((JSONObject)JSONObject.toJSON(tradeMap), "trade_detail_record_h"));
//			  }
//			  metadataService.batchUpdate(sqls.toArray(new String[sqls.size()]));
//		  }
//		  log.info("back stock trade detail data! is ok!");
//		  System.out.println("back stock trade detail data! is ok!");
	 }
	 @Scheduled(cron="0 09 12 * * ?")
	 public void reptileNewStock(){
			 HttpClient httpClient = new HttpClient();
			 String htmlContent = httpClient.httpGet("http://stock.gtimg.cn/data/index.php?appn=rank&t=ranka/chr&p=1&o=0&l=60&v=list_data", "utf-8");
			 JSONObject datajson = new JSONObject();
			 datajson = JSONObject.parseObject(htmlContent.substring(htmlContent.indexOf("{"),htmlContent.lastIndexOf("}")+1));
			 int total = datajson.getIntValue("total");
			 echo:for(int i=1;i<=total;i++){
				 htmlContent = httpClient.httpGet("http://stock.gtimg.cn/data/index.php?appn=rank&t=ranka/chr&p="+i+"&o=0&l=60&v=list_data", "utf-8");
				 datajson = JSONObject.parseObject(htmlContent.substring(htmlContent.indexOf("{"),htmlContent.lastIndexOf("}")+1));
				 String st_array = "";
				 for(String stock_no_buff:datajson.getString("data").split(",")){
					 st_array +="'"+stock_no_buff+"',";
				 }
				 List<Map<String,Object>> stockList = metadataService.queryForList("SELECT * FROM STOCK_RECORD WHERE STOCK_NO_BUFF IN("+st_array.substring(0, st_array.length()-1)+")");
				 Map<String, String> stock_current_Map =  new HashMap<>();
				 if(stockList!=null && stockList.size()>0){
					 for(Map<String,Object> stockMap: stockList){
						 stock_current_Map.put(stockMap.get("STOCK_NO_BUFF").toString(), stockMap.get("STOCK_NO_BUFF").toString());
					 }
				 }
				 for(String stock_no_buff:datajson.getString("data").split(",")){
					 if(!stock_current_Map.containsKey(stock_no_buff)){
					 JSONObject stockJson = new JSONObject();
//					 stockJson.put("SEQNO", metadataService.getPrimaryValue("stock_record"));
					 stockJson.put("STOCK_NO_BUFF", stock_no_buff);
					 stockJson.put("STOCK_NO", stock_no_buff.substring(2,stock_no_buff.length()));
					 metadataService.execute(metadataService.getsql(stockJson, "stock_record"));
					 metadataService.execute("INSERT INTO trade_detail_config(STOCK_NO,STOCK_NO_BUFF) VALUES('"+stock_no_buff.substring(2,stock_no_buff.length())+"','"+stock_no_buff+"')");
					 metadataService.execute("INSERT INTO stock_spi_record(STOCK_NO,STOCK_NO_BUFF) VALUES('"+stock_no_buff.substring(2,stock_no_buff.length())+"','"+stock_no_buff+"')");
					 }
			 }
			 }
	 }
}
