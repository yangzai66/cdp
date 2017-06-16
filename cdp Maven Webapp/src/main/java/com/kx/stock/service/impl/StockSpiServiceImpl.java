package com.kx.stock.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.service.IStockSpiService;
import com.kx.util.JsonUtil;
import com.kx.util.ST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stockSpiService")
public class StockSpiServiceImpl implements IStockSpiService{
	@Autowired
	IMetadataService metadataService;
	static List<String> reptileDate = new ArrayList<String>();
	public void lxfl() {
		// TODO Auto-generated method stub
		String lxfl2 = "SELECT T1.STOCK_NO FROM "+
                       " (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(0)+"') T1, " +
					   " (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(1)+"') T2 " +
                       " WHERE T1.STOCK_NO = T2.STOCK_NO  AND T1.TRADE_TOTAL_NUM > T2.TRADE_TOTAL_NUM";
		String lxfl3 = "SELECT T1.STOCK_NO FROM "+
                " (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(0)+"') T1, " +
				" (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(1)+"') T2, " +
				" (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(2)+"') T3 " +
                " WHERE T1.STOCK_NO = T2.STOCK_NO AND T1.STOCK_NO=T3.STOCK_NO  AND T1.TRADE_TOTAL_NUM > T2.TRADE_TOTAL_NUM AND T2.TRADE_TOTAL_NUM > T3.TRADE_TOTAL_NUM";
		String lxfl4 = "SELECT T1.STOCK_NO FROM "+
                " (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(0)+"') T1," +
				" (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(1)+"') T2, " +
				" (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(2)+"') T3, " +
				" (SELECT TRADE_TOTAL_NUM,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME='"+ST.reptileDates.get(3)+"') T4 " +
                " WHERE T1.STOCK_NO = T2.STOCK_NO AND T1.STOCK_NO=T3.STOCK_NO AND T1.STOCK_NO = T4.STOCK_NO  AND T1.TRADE_TOTAL_NUM > T2.TRADE_TOTAL_NUM AND T2.TRADE_TOTAL_NUM > T3.TRADE_TOTAL_NUM AND T3.TRADE_TOTAL_NUM > T4.TRADE_TOTAL_NUM";
		    updateSpi(metadataService.queryForList(lxfl2),"SPI_LXFL_2");
		    updateSpi(metadataService.queryForList(lxfl3),"SPI_LXFL_3");
		    updateSpi(metadataService.queryForList(lxfl4),"SPI_LXFL_4");
	}
	public void lxsz() {
		String lxsz2="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"') AND UPS_DOWNS_RATE >0 GROUP BY STOCK_NO HAVING COUNT(*)=2";
		String lxsz3="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') AND UPS_DOWNS_RATE >0 GROUP BY STOCK_NO HAVING COUNT(*)=3";
		String lxsz4="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"','"+ST.reptileDates.get(3)+"') AND UPS_DOWNS_RATE >0 GROUP BY STOCK_NO HAVING COUNT(*)=4";
		updateSpi(metadataService.queryForList(lxsz2), "SPI_LXSZ_2");
		updateSpi(metadataService.queryForList(lxsz3), "SPI_LXSZ_3");
		updateSpi(metadataService.queryForList(lxsz4), "SPI_LXSZ_4");
	}
	public void lxxd() {
		String lxxd2="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"') AND UPS_DOWNS_RATE <0 GROUP BY STOCK_NO HAVING COUNT(*)=2";
		String lxxd3="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') AND UPS_DOWNS_RATE <0 GROUP BY STOCK_NO HAVING COUNT(*)=3";
		String lxxd4="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"','"+ST.reptileDates.get(3)+"') AND UPS_DOWNS_RATE <0 GROUP BY STOCK_NO HAVING COUNT(*)=4";
		updateSpi(metadataService.queryForList(lxxd2), "SPI_LXXD_2");
		updateSpi(metadataService.queryForList(lxxd3), "SPI_LXXD_3");
		updateSpi(metadataService.queryForList(lxxd4), "SPI_LXXD_4");
	}
	public void lxjlr(){
		String lxjlr2="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"') AND FUND_MAIN_PURE >0 GROUP BY STOCK_NO HAVING COUNT(*)=2";
		String lxjlr3="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') AND FUND_MAIN_PURE >0 GROUP BY STOCK_NO HAVING COUNT(*)=3";
		updateSpi(metadataService.queryForList(lxjlr2), "SPI_LXJLR_2");
		updateSpi(metadataService.queryForList(lxjlr3), "SPI_LXJLR_3");
	}
	public void lxjlc(){
		String lxjlr2="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"') AND FUND_MAIN_PURE <0 GROUP BY STOCK_NO HAVING COUNT(*)=2";
		String lxjlr3="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') AND FUND_MAIN_PURE <0 GROUP BY STOCK_NO HAVING COUNT(*)=3";
		updateSpi(metadataService.queryForList(lxjlr2), "SPI_LXJLC_2");
		updateSpi(metadataService.queryForList(lxjlr3), "SPI_LXJLC_3");
	}
	public void lxdd(){
		String lxjlr2="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"') AND BUY_5 >0 GROUP BY STOCK_NO HAVING COUNT(*)=2";
		String lxjlr3="SELECT STOCK_NO,COUNT(*) FROM STOCK_RECORD_H WHERE CREATETIME IN('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') AND BUY_5 >0 GROUP BY STOCK_NO HAVING COUNT(*)=3";
		updateSpi(metadataService.queryForList(lxjlr2), "SPI_LXDD_2");
		updateSpi(metadataService.queryForList(lxjlr3), "SPI_LXDD_3");
	}
	public void ups_downs_rate(){
		String ups_downs_rate_sql3 = "SELECT CAST(SUM(UPS_DOWNS_RATE) AS DECIMAL(10,2)) SPI_RATE_3,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') GROUP BY STOCK_NO";
		String ups_downs_rate_sql5 = "SELECT CAST(SUM(UPS_DOWNS_RATE) AS DECIMAL(10,2)) SPI_RATE_5,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"','"+ST.reptileDates.get(3)+"','"+ST.reptileDates.get(4)+"') GROUP BY STOCK_NO";
		updateSpiTag(metadataService.queryForList(ups_downs_rate_sql3), "SPI_RATE_3");
		updateSpiTag(metadataService.queryForList(ups_downs_rate_sql5), "SPI_RATE_5");
	}
	public void amplitude(){
		String avg_amplitude3 = "SELECT CAST(AVG(REFERENCE_AMPLITUDE) AS DECIMAL(10,2)) SPI_AVG_AMPLITUDE_3,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') GROUP BY STOCK_NO";
		String avg_amplitude5 = "SELECT CAST(AVG(REFERENCE_AMPLITUDE) AS DECIMAL(10,2)) SPI_AVG_AMPLITUDE_5,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"','"+ST.reptileDates.get(3)+"','"+ST.reptileDates.get(4)+"') GROUP BY STOCK_NO";
		System.out.println("---"+avg_amplitude3);
		System.out.println("---"+avg_amplitude5);
		updateSpiTag(metadataService.queryForList(avg_amplitude3), "SPI_AVG_AMPLITUDE_3");
		updateSpiTag(metadataService.queryForList(avg_amplitude5), "SPI_AVG_AMPLITUDE_5");
	}
	public void high_price(){
		String high_price3 = "SELECT MAX(HIGH_PRICE) SPI_HIGH_PRICE_3,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') GROUP BY STOCK_NO";
		String high_price5 = "SELECT MAX(HIGH_PRICE) SPI_HIGH_PRICE_5,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"','"+ST.reptileDates.get(3)+"','"+ST.reptileDates.get(4)+"') GROUP BY STOCK_NO";
		updateSpiTag(metadataService.queryForList(high_price3), "SPI_HIGH_PRICE_3");
		updateSpiTag(metadataService.queryForList(high_price5), "SPI_HIGH_PRICE_5");
	}
	public void low_price(){
		String low_price3 = "SELECT MIN(LOW_PRICE) SPI_LOW_PRICE_3,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') GROUP BY STOCK_NO";
		String low_price5 = "SELECT MIN(LOW_PRICE) SPI_LOW_PRICE_5,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"','"+ST.reptileDates.get(3)+"','"+ST.reptileDates.get(4)+"') GROUP BY STOCK_NO";
		updateSpiTag(metadataService.queryForList(low_price3), "SPI_LOW_PRICE_3");
		updateSpiTag(metadataService.queryForList(low_price5), "SPI_LOW_PRICE_5");
	}
	public void updateSpi(List<Map<String, Object>> spiList,String spiFiled) {
		if(spiList!=null && spiList.size()>0){
			List<String> sqls = new ArrayList<String>();
	    	for(Map<String, Object> map:spiList){
//	    		System.out.println("UPDATE STOCK_SPI_RECORD SET "+spiFiled+"='1' WHERE STOCK_NO='"+map.get("STOCK_NO")+"'");
//	    		metadataService.execute("UPDATE STOCK_SPI_RECORD SET "+spiFiled+"='1' WHERE STOCK_NO='"+map.get("STOCK_NO")+"'");
	    		sqls.add("UPDATE STOCK_SPI_RECORD SET "+spiFiled+"='1' WHERE STOCK_NO='"+map.get("STOCK_NO")+"'");
	    	}
	    	metadataService.batchUpdate(sqls.toArray(new String[sqls.size()]));
	    }
	}
	public void turnover(){
		String avg_turnover3 = "SELECT CAST(AVG(LOW_PRICE) AS DECIMAL(10,2)) SPI_AVG_TURNOVER_3,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"') GROUP BY STOCK_NO";
		String avg_turnover5 = "SELECT CAST(AVG(LOW_PRICE) AS DECIMAL(10,2)) SPI_AVG_TURNOVER_5,STOCK_NO FROM STOCK_RECORD_H WHERE CREATETIME IN ('"+ST.reptileDates.get(0)+"','"+ST.reptileDates.get(1)+"','"+ST.reptileDates.get(2)+"','"+ST.reptileDates.get(3)+"','"+ST.reptileDates.get(4)+"') GROUP BY STOCK_NO";
		updateSpiTag(metadataService.queryForList(avg_turnover3), "SPI_AVG_TURNOVER_3");
		updateSpiTag(metadataService.queryForList(avg_turnover5), "SPI_AVG_TURNOVER_5");
	}
	public void updateSpiTag(List<Map<String, Object>> spiList,String spiFiled) {
		if(spiList!=null && spiList.size()>0){
			List<String> sqls = new ArrayList<String>();
	    	for(Map<String, Object> map:spiList){
	    		if(map.get(spiFiled).equals("--")){
	    			map.put(spiFiled, "0.00");
	    		}
	    		sqls.add("UPDATE STOCK_SPI_RECORD SET "+spiFiled+"='"+map.get(spiFiled)+"' WHERE STOCK_NO='"+map.get("STOCK_NO")+"'");
	    	}
	    	metadataService.batchUpdate(sqls.toArray(new String[sqls.size()]));
	    }
	}
    
	public static void main(String[] args) {
		
	}
	@Override
	public JSONObject list(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
		System.out.println("SELECT * FROM STOCK_SPI_RECORD,STOCK_RECORD WHERE STOCK_SPI_RECORD.STOCK_NO=STOCK_RECORD.STOCK_NO "+dataJson.getString("where") + dataJson.getString("order"));
		resultJson.put("data", metadataService.queryForList("SELECT * FROM STOCK_SPI_RECORD,STOCK_RECORD WHERE STOCK_SPI_RECORD.STOCK_NO=STOCK_RECORD.STOCK_NO "+dataJson.getString("where") + dataJson.getString("order")));
		return resultJson;
	}
	public List<String> getReptileDates(){
		List<String> list =  new ArrayList<String>();
		List<Map<String, Object>> rList = metadataService.queryForList("SELECT CREATETIME FROM STOCK_RECORD_H GROUP BY CREATETIME ORDER BY CREATETIME DESC");
		for(Map<String, Object> map:rList){
			list.add(map.get("CREATETIME").toString());
		}
		return list;
	}
	@Override
	public JSONObject analyze(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
		ST.reptileDates = getReptileDates();
		lxdd();
		lxfl();
		lxjlc();
		lxjlr();
		lxsz();
		lxxd();
		low_price();
		high_price();
		low_price();
		turnover();
		amplitude();
		ups_downs_rate();
		return resultJson;
		
	}
}
