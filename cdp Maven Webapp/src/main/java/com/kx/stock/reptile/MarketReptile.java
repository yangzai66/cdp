package com.kx.stock.reptile;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.kx.listener.SpringContextHolder;
import com.kx.metadata.service.IMetadataService;
import com.kx.util.DateTimeUtil;
import com.kx.util.HttpClient;
import com.kx.util.ST;

public class MarketReptile implements Runnable{
	IMetadataService metadataService = SpringContextHolder.getBean("metadataService");
	@Override
	public void run() {
		HttpClient httpClient = new HttpClient();
		String stock_no_buff="";
		for(String tag:ST.marketJson.keySet()){
			stock_no_buff+=tag+",";
		}
		
			while (true) {
				try {
				Thread.sleep(5000);
				String content = httpClient.httpGet("http://push1.gtimg.cn/q="+stock_no_buff.substring(0,stock_no_buff.length()-1), "UTF-8");
				if(StringUtils.isNotEmpty(content)){
					for(String sing:content.split(";")){
						if(StringUtils.isEmpty(sing.trim())) break;
						String tag_stock_buff = sing.trim().substring(2,10);
						sing = sing.substring(sing.indexOf("\"")+1, sing.length()-2);
						String [] stock = sing.split("~");
							ST.marketJson.getJSONObject(tag_stock_buff).put("STOCK_NAME", stock[1]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("LIMIT_UP", stock[47]==""?"0.00":stock[47]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("LIMIT_DOWN", stock[48]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_TOTAL_PRICE", stock[37]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_TOTAL_NUM", stock[36]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TURNOVER_RATE", stock[38].length()==0?"0.00":stock[38]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("HIGH_PRICE", stock[33]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("LOW_PRICE", stock[34]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("CUR_PRICE", stock[3]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("LIMIT_OPEN", stock[5]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("UPS_DOWNS_RATE", stock[32]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("UPS_DOWNS_PRICE", stock[31]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("OUTSIZE", stock[7]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("INNERSIZE", stock[8]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_1", stock[9]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_1", stock[10]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_2", stock[11]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_2", stock[12]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_3", stock[13]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_3", stock[14]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_4", stock[15]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_4", stock[16]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_5", stock[17]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_5", stock[18]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_1", stock[19]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_1", stock[20]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_2", stock[21]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_2", stock[22]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_3", stock[23]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_3", stock[24]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_4", stock[25]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_4", stock[26]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_5", stock[27]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_5", stock[28]);
							//ST.marketJson.getJSONObject(tag_stock_buff).put("LATELY_TRADE", stock[29]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("TOTAL_MARKET_VALUE", stock[45].length()==0?"0.00":stock[45]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("CIRCULATE_MARKET_VALUE", stock[44].length()==0?"0.00":stock[44]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("REFERENCE_AMPLITUDE", stock[43]);
							ST.marketJson.getJSONObject(tag_stock_buff).put("UPDATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
							ST.marketJson.getJSONObject(tag_stock_buff).put("CREATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATE_FORMAT));
//							metadataService.execute(metadataService.getsql(ST.marketJson.getJSONObject(tag_stock_buff), "stock_record","SEQNO",ST.marketJson.getJSONObject(tag_stock_buff).getString("SEQNO")));
							metadataService.execute(metadataService.getsql(ST.marketJson.getJSONObject(tag_stock_buff), "market_record","SEQNO",ST.marketJson.getJSONObject(tag_stock_buff).getString("SEQNO")));
					}
				}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		
		
		
	
		
	}

}
