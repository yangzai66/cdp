package com.kx.stock.reptile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.kx.listener.SpringContextHolder;
import com.kx.metadata.service.IMetadataService;
import com.kx.util.ST;

public class StockTask implements Runnable{

	IMetadataService metadataService =SpringContextHolder.getBean("metadataService");
	@Override
	public void run() {
		
		echo:while(true){
			try{
			if(ST.trade_array!=null && ST.trade_array.keySet().size()>0){
//				List<String> tempList = new ArrayList<String>();
//				tempList.
//				String temp_sql ="";
//				for(Object stock_no_buff1:ST.trade_array.keySet()){
//					String stock_no_buff =stock_no_buff1.toString();
////					System.out.println("update trade_detail_config set TOTAL_PAGE=TOTAL_PAGE+1,USE_STATUS='0',TOTAL_PAGE="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("TOTAL_PAGE")+",CUR_PAGE="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("CUR_PAGE")+",PAGE_INDEX="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("PAGE_INDEX")+",CUR_TIME='"+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getString("CUR_TIME")+"' where STOCK_NO_BUFF ='"+stock_no_buff+"'");
//					metadataService.execute("update trade_detail_config set TOTAL_PAGE=TOTAL_PAGE+1,USE_STATUS='0',TOTAL_PAGE="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("TOTAL_PAGE")+",CUR_PAGE="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("CUR_PAGE")+",PAGE_INDEX="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("PAGE_INDEX")+",CUR_TIME='"+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getString("CUR_TIME")+"' where STOCK_NO_BUFF ='"+stock_no_buff+"'");
//					ST.trade_array.remove(stock_no_buff1);
////					temp_sql+="'"+stock_no_buff+"',";
//				}
//				111111222
//				metadataService.execute("update trade_detail_config set TOTAL_PAGE=TOTAL_PAGE+1,USE_STATUS='0'¡®¡¯¡®¡¯¡®¡¯¡®¡¯¡®¡¯¡®' where STOCK_NO in("+temp_sql.substring(0,temp_sql.length()-1)+")");
			}
			List<Map<String,Object>> stock_list = metadataService.queryForList("SELECT * FROM trade_detail_config WHERE IS_REPTILE='1' AND USE_STATUS='0' and STOCK_NO not like '300%'");
			if(stock_list==null || stock_list.size()==0){
				Thread.sleep(5000);
				continue echo;
			}
//		if(ST.trade_detailsConfig.isEmpty()){
			for(Map<String, Object> stock_map:stock_list){
				JSONObject dataJson = new JSONObject();
				dataJson.put("STOCK_NO", stock_map.get("STOCK_NO"));
				dataJson.put("STOCK_NO_BUFF", stock_map.get("STOCK_NO_BUFF"));
				dataJson.put("TOTAL_PAGE", stock_map.get("TOTAL_PAGE"));
				dataJson.put("CUR_PAGE", stock_map.get("CUR_PAGE"));
				dataJson.put("PAGE_INDEX", stock_map.get("PAGE_INDEX"));
				dataJson.put("USE_STATUS", stock_map.get("USE_STATUS"));
				ST.trade_detailsConfig.put(stock_map.get("STOCK_NO_BUFF").toString(),dataJson);
			}
//			System.out.println("---"+ST.trade_detailsConfig.toJSONString());
//			System.out.println(ST.trade_detailsConfig.keySet().size());
//		}
		List<String> tempList = new ArrayList<String>();
		String stock_no_temp ="";
		for(int i=0;i<stock_list.size();i++){
			tempList.add(stock_list.get(i).get("STOCK_NO_BUFF").toString());
			stock_no_temp+="'"+stock_list.get(i).get("STOCK_NO_BUFF")+"',";
			if((i!=0 && i%160==0) || i==stock_list.size()-1){
				StockReptile stockReptile = new StockReptile(tempList);
				Thread thread = new Thread(stockReptile);
				thread.start();
				metadataService.execute("UPDATE trade_detail_config SET USE_STATUS='1' WHERE STOCK_NO_BUFF IN("+stock_no_temp.substring(0,stock_no_temp.length()-1)+")");
				tempList = new ArrayList<String>();
				stock_no_temp="";
			}
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
	}


}
