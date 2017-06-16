package com.kx.stock.reptile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.record.PageBreakRecord.Break;

import com.alibaba.fastjson.JSONObject;
import com.kx.listener.SpringContextHolder;
import com.kx.metadata.service.IMetadataService;
import com.kx.util.DateTimeUtil;
import com.kx.util.HttpClient;
import com.kx.util.ST;

public class StockReptile implements Runnable{

	IMetadataService metadataService = SpringContextHolder.getBean("metadataService");
	public List<String> stock_list = new ArrayList<String>();
	private Log log = LogFactory.getLog(StockReptile.class);
	public StockReptile(List<String> stocklist){
		this.stock_list = stocklist;
	}
	public void repitileStock(List<String> stockList){
		String stock_no_buff="";
		for(String tag:stockList){
			stock_no_buff+=tag+",";
		}
		String	content = httpHelp("http://qt.gtimg.cn/q="+stock_no_buff.substring(0,stock_no_buff.length()-1));
		for(String sing:content.split(";")){
			String tag_stock_buff = sing.trim().substring(2,10);
			sing = sing.substring(sing.indexOf("\"")+1, sing.length()-2);
			String [] stock = sing.split("~");
			String fundFlow = httpHelp("http://qt.gtimg.cn/q=ff_"+tag_stock_buff);
//			System.out.println("http://qt.gtimg.cn/q=ff_"+tag_stock_buff);
			if(StringUtils.isNoneEmpty(fundFlow) && fundFlow.indexOf("~")>0){
				fundFlow = fundFlow.substring(fundFlow.indexOf("\"")+1, fundFlow.length()-2);
				String [] fundArray = fundFlow.split("~");
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_MAIN_INFLOW", fundArray[1]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_MAIN_OUTFLOW", fundArray[2]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_MAIN_PURE", fundArray[3]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_MAIN_PURE_RATIO", fundArray[4]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_RETAIL_INFLOW", fundArray[5]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_RETAIL_OUTFLOW", fundArray[6]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_RETAIL_PURE", fundArray[7]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_RETAIL_PURE_RATIO", fundArray[8]);
				ST.allStock.getJSONObject(tag_stock_buff).put("FUND_TOTAL_TRADE", fundArray[9]);
			}
//			JSONObject stockJson = new JSONObject();
				ST.allStock.getJSONObject(tag_stock_buff).put("STOCK_NAME", stock[1]);
				ST.allStock.getJSONObject(tag_stock_buff).put("LIMIT_UP", stock[47]);
				ST.allStock.getJSONObject(tag_stock_buff).put("LIMIT_DOWN", stock[48]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_TOTAL_PRICE", stock[37]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_TOTAL_NUM", stock[36]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TURNOVER_RATE", stock[38]);
				ST.allStock.getJSONObject(tag_stock_buff).put("HIGH_PRICE", stock[33]);
				ST.allStock.getJSONObject(tag_stock_buff).put("LOW_PRICE", stock[34]);
				ST.allStock.getJSONObject(tag_stock_buff).put("CUR_PRICE", stock[3]);
				ST.allStock.getJSONObject(tag_stock_buff).put("LIMIT_OPEN", stock[5]);
				ST.allStock.getJSONObject(tag_stock_buff).put("UPS_DOWNS_RATE", stock[32]);
				ST.allStock.getJSONObject(tag_stock_buff).put("UPS_DOWNS_PRICE", stock[31]);
				ST.allStock.getJSONObject(tag_stock_buff).put("OUTSIZE", stock[7]);
				ST.allStock.getJSONObject(tag_stock_buff).put("INNERSIZE", stock[8]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_1", stock[9]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_1", stock[10]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_2", stock[11]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_2", stock[12]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_3", stock[13]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_3", stock[14]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_4", stock[15]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_4", stock[16]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_PRICE_5", stock[17]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_BUY_NUMBER_5", stock[18]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_1", stock[19]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_1", stock[20]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_2", stock[21]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_2", stock[22]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_3", stock[23]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_3", stock[24]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_4", stock[25]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_4", stock[26]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_PRICE_5", stock[27]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TRADE_SALE_NUMBER_5", stock[28]);
				//ST.allStock.getJSONObject(tag_stock_buff).put("LATELY_TRADE", stock[29]);
				ST.allStock.getJSONObject(tag_stock_buff).put("TOTAL_MARKET_VALUE", stock[45]);
				ST.allStock.getJSONObject(tag_stock_buff).put("CIRCULATE_MARKET_VALUE", stock[44]);
				ST.allStock.getJSONObject(tag_stock_buff).put("REFERENCE_AMPLITUDE", stock[43]);
				ST.allStock.getJSONObject(tag_stock_buff).put("PE", stock[39].length()==0?"0.0":stock[39]);
				ST.allStock.getJSONObject(tag_stock_buff).put("PB", stock[46].length()==0?"0.0":stock[46]);
				ST.allStock.getJSONObject(tag_stock_buff).put("UPDATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
				ST.allStock.getJSONObject(tag_stock_buff).put("CREATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATE_FORMAT));
				for(String key:ST.allStock.getJSONObject(tag_stock_buff).keySet()){
					if(ST.allStock.getJSONObject(tag_stock_buff).getString(key).length()==0){
						ST.allStock.getJSONObject(tag_stock_buff).put(key, "0");
					}
				}
				metadataService.execute(metadataService.getsql(ST.allStock.getJSONObject(tag_stock_buff), "stock_record","SEQNO",ST.allStock.getJSONObject(tag_stock_buff).getString("SEQNO")));
		}
		
	}
	@Override
	public void run() {
		try {
			repitileStock(stock_list);
			echo:for(String stock_no_buff:stock_list){
				//check is need reptile data
				try {
					String stock_time = httpHelp("http://stock.gtimg.cn/data/index.php?appn=detail&action=timeline&c="+stock_no_buff);
					if(StringUtils.isNotEmpty(stock_time) && stock_time.indexOf("\"")>0){
						stock_time = stock_time.substring(stock_time.indexOf("\"")+1, stock_time.lastIndexOf("\""));
						String [] timeArray = stock_time.split("[|]");
						if(timeArray!=null && timeArray.length>0){
//							System.out.println(stock_no_buff);
//							System.out.println(ST.trade_detailsConfig.getJSONObject(stock_no_buff).toJSONString());
							ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("TOTAL_PAGE", timeArray.length);
//							if()
							tag:for(int i=ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("CUR_PAGE");i<timeArray.length;i++){
								ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("CUR_TIME", timeArray[i]);
								//if(ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("PAGE_STATUS")==0){
									String page_content = httpHelp("http://stock.gtimg.cn/data/index.php?appn=detail&action=data&c="+stock_no_buff+"&p="+i);
									if(StringUtils.isNotEmpty(page_content) && page_content.indexOf("\"")>0){
										List<String> tradeSqlArray = new ArrayList<String>();
										page_content = page_content.substring(page_content.indexOf("\"")+1, page_content.lastIndexOf("\""));
										String [] pageArray = page_content.split("[|]");
										if(ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("PAGE_INDEX")==pageArray.length-1 && ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("CUR_PAGE")!=timeArray.length-1){
											ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("PAGE_INDEX", 0);
											ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("CUR_PAGE", i+1);
											continue tag;
										}
										for(int k=ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("PAGE_INDEX");k<pageArray.length;k++){
											JSONObject dataJson =  new JSONObject();
											dataJson.put("SEQNO", UUID.randomUUID());
											dataJson.put("TRADE_TIME", pageArray[k].split("/")[1]);
											dataJson.put("TRADE_PRICE", pageArray[k].split("/")[2]);
											dataJson.put("TRADE_NUM", pageArray[k].split("/")[4]);
											dataJson.put("TRADE_TYPE", pageArray[k].split("/")[6]);
											dataJson.put("TRADE_TOTAL_PRICE",pageArray[k].split("/")[5]);
											dataJson.put("CREATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATE_FORMAT));
											dataJson.put("STOCK_NO", ST.trade_detailsConfig.getJSONObject(stock_no_buff).getString("STOCK_NO"));
											JSONObject messageJson =  new JSONObject();
											if(dataJson.getString("TRADE_TYPE").equals("B")){
												if(dataJson.getIntValue("TRADE_TOTAL_PRICE")<1000000){
													ST.allStock.getJSONObject(stock_no_buff).put("BUY_1", ST.allStock.getJSONObject(stock_no_buff).getIntValue("BUY_1")+1);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>1000000 && dataJson.getIntValue("TRADE_TOTAL_PRICE")<=3000000){
													ST.allStock.getJSONObject(stock_no_buff).put("BUY_2", ST.allStock.getJSONObject(stock_no_buff).getIntValue("BUY_2")+1);
													messageJson.put("LEVEL", 2);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>3000000 && dataJson.getIntValue("TRADE_TOTAL_PRICE")<=5000000){
													ST.allStock.getJSONObject(stock_no_buff).put("BUY_3", ST.allStock.getJSONObject(stock_no_buff).getIntValue("BUY_3")+1);
													messageJson.put("LEVEL", 3);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>5000000 && dataJson.getIntValue("TRADE_TOTAL_PRICE")<=10000000){
													ST.allStock.getJSONObject(stock_no_buff).put("BUY_4", ST.allStock.getJSONObject(stock_no_buff).getIntValue("BUY_4")+1);
													messageJson.put("LEVEL", 4);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>10000000){
													ST.allStock.getJSONObject(stock_no_buff).put("BUY_5", ST.allStock.getJSONObject(stock_no_buff).getIntValue("BUY_5")+1);
													messageJson.put("LEVEL", 5);
												}
											}else if(dataJson.getString("TRADE_TYPE").equals("S")){
												if(dataJson.getIntValue("TRADE_TOTAL_PRICE")<1000000){
													ST.allStock.getJSONObject(stock_no_buff).put("SELL_1", ST.allStock.getJSONObject(stock_no_buff).getIntValue("SELL_1")+1);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>1000000 && dataJson.getIntValue("TRADE_TOTAL_PRICE")<=3000000){
													ST.allStock.getJSONObject(stock_no_buff).put("SELL_2", ST.allStock.getJSONObject(stock_no_buff).getIntValue("SELL_2")+1);
													messageJson.put("LEVEL", 2);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>3000000 && dataJson.getIntValue("TRADE_TOTAL_PRICE")<=5000000){
													ST.allStock.getJSONObject(stock_no_buff).put("SELL_3", ST.allStock.getJSONObject(stock_no_buff).getIntValue("SELL_3")+1);
													messageJson.put("LEVEL", 3);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>5000000 && dataJson.getIntValue("TRADE_TOTAL_PRICE")<=10000000){
													ST.allStock.getJSONObject(stock_no_buff).put("SELL_4", ST.allStock.getJSONObject(stock_no_buff).getIntValue("SELL_4")+1);
													messageJson.put("LEVEL", 4);
												}else if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>10000000){
													ST.allStock.getJSONObject(stock_no_buff).put("SELL_5", ST.allStock.getJSONObject(stock_no_buff).getIntValue("SELL_5")+1);
													messageJson.put("LEVEL", 5);
												}
											}
											if(dataJson.getIntValue("TRADE_TOTAL_PRICE")>1000000){
												messageJson.put("SEQNO", UUID.randomUUID());
												messageJson.put("STOCK_NO", ST.trade_detailsConfig.getJSONObject(stock_no_buff).getString("STOCK_NO"));
												messageJson.put("TRADE_TYPE", dataJson.getString("TRADE_TYPE"));
												messageJson.put("STOCK_NAME", ST.allStock.getJSONObject(stock_no_buff).getString("STOCK_NAME"));
												messageJson.put("CUR_PRICE", ST.allStock.getJSONObject(stock_no_buff).getString("CUR_PRICE"));
												messageJson.put("TRADE_NUM", dataJson.getIntValue("TRADE_NUM"));
												messageJson.put("TRADE_TOTAL_PRICE", dataJson.getIntValue("TRADE_TOTAL_PRICE")/10000);
												messageJson.put("TRADE_PRICE", dataJson.getString("TRADE_PRICE"));
												messageJson.put("HIGH_PRICE", ST.allStock.getJSONObject(stock_no_buff).getString("HIGH_PRICE"));
												messageJson.put("LOW_PRICE", ST.allStock.getJSONObject(stock_no_buff).getString("LOW_PRICE"));
												messageJson.put("UPS_DOWNS_RATE", ST.allStock.getJSONObject(stock_no_buff).getString("UPS_DOWNS_RATE"));
												messageJson.put("REFERENCE_AMPLITUDE", ST.allStock.getJSONObject(stock_no_buff).getString("REFERENCE_AMPLITUDE"));
												messageJson.put("LIMIT_OPEN", ST.allStock.getJSONObject(stock_no_buff).getString("LIMIT_OPEN"));
												messageJson.put("TURNOVER_RATE", ST.allStock.getJSONObject(stock_no_buff).getString("TURNOVER_RATE"));
												messageJson.put("TRADE_TIME", dataJson.getString("TRADE_TIME"));
												messageJson.put("CREATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATE_FORMAT));
												tradeSqlArray.add(metadataService.getsql(messageJson, "message_record"));
											}
											tradeSqlArray.add(metadataService.getsql(dataJson, "trade_detail_record"));
											ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("PAGE_INDEX", k+1);
											if(ST.trade_detailsConfig.getJSONObject(stock_no_buff).getString("CUR_TIME").indexOf(pageArray[k].split("/")[1])>0){
												//ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("PAGE_STATUS",1);
												if(timeArray.length!=i+1){
													ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("PAGE_INDEX", 0);
													ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("CUR_PAGE", i+1);
													
												}
											}
											if(DateTimeUtil.misBetween(DateTimeUtil.parseDate("14:59:30", DateTimeUtil.DEFAULT_TIME_FORMAT), DateTimeUtil.parseDate(pageArray[k].split("/")[1], DateTimeUtil.DEFAULT_TIME_FORMAT))>=0){
												metadataService.execute("update trade_detail_config set IS_REPTILE='0' WHERE STOCK_NO_BUFF='"+stock_no_buff+"'");
											}
										}
										if(null!=tradeSqlArray && tradeSqlArray.size()>0){
											metadataService.batchUpdate(tradeSqlArray.toArray(new String [tradeSqlArray.size()]));
										}
									}else{
										continue echo;
									}
								}
							//}
						}
					}
				} catch (Exception e) {
					log.error(stock_no_buff+" δ��ȡ����ϸʱ��������Ϣ��");
					e.printStackTrace();
					continue echo;
				}
//				ST.trade_array.put(stock_no_buff,"isload");
//				metadataService.execute("update trade_detail_config set TOTAL_PAGE=TOTAL_PAGE+1,USE_STATUS='0',TOTAL_PAGE="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("TOTAL_PAGE")+",CUR_PAGE="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("CUR_PAGE")+",PAGE_INDEX="+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getIntValue("PAGE_INDEX")+",CUR_TIME='"+ST.trade_detailsConfig.getJSONObject(stock_no_buff).getString("CUR_TIME")+"' where STOCK_NO_BUFF ='"+stock_no_buff+"'");
				ST.trade_detailsConfig.getJSONObject(stock_no_buff).put("USE_STATUS", "0");
				metadataService.execute(metadataService.getsql(ST.trade_detailsConfig.getJSONObject(stock_no_buff), "trade_detail_config", "STOCK_NO_BUFF", ST.trade_detailsConfig.getJSONObject(stock_no_buff).getString("STOCK_NO_BUFF")));
				metadataService.execute(metadataService.getsql(ST.allStock.getJSONObject(stock_no_buff), "stock_record","SEQNO",ST.allStock.getJSONObject(stock_no_buff).getString("SEQNO")));
			}
//			metadataService.batchUpdate(stockSqls.toArray(new String[stockSqls.size()]));
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error("reptile trade details generate exception! message:"+e.getMessage());
		}
	}
	public String httpHelp(String url){
		HttpClient httpClient = new HttpClient();
		String content =null;
		for(int i=0;i<10;i++){
			if(i!=0){
			try {
//				if(url.indexOf("qt2")==-1){
//				url.replace("qt", "qt2");
//				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			try {
//				System.out.println(url);
				content = httpClient.httpGet(url, "gb18030").trim();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(content!=null){
				break;
			}
		}
		return content;
	}
}
