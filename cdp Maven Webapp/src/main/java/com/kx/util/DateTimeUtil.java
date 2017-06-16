package com.kx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	/**缺省日期格式*/
	  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	  
	  /**缺省时间格式*/
	  public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	  /**缺省月格式*/
	  public static final String DEFAULT_MONTH = "MONTH";

	  /**缺省年格式*/
	  public static final String DEFAULT_YEAR = "YEAR";

	  /**缺省日格式*/
	  public static final String DEFAULT_DATE = "DAY";

	  /**缺省小时格式*/
	  public static final String DEFAULT_HOUR = "HOUR";
	  
	  /**缺省分钟格式*/
	  public static final String DEFAULT_MINUTE = "MINUTE";
	  
	  /**缺省秒格式*/
	  public static final String DEFAULT_SECOND = "SECOND";
	  
	  /**缺省长日期格式*/
	  public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH-mm";

	  /**缺省长日期格式,精确到秒*/
	  public static final String DEFAULT_DATETIME_FORMAT_SEC = "yyyy-MM-dd HH:mm:ss";

	  /**星期数组*/
	  public static final String[] WEEKS = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
	  
	  public static String getCurDate(String format){
		  return getSimpleDateFormat(format).format(new Date());
	  }
	  /**
	   * 获取格式化对象
	   * @param strFormat 格式化的格式 如"yyyy-MM-dd"
	   * @return 格式化对象
	   */
	  public static SimpleDateFormat getSimpleDateFormat(String strFormat){
		  if(strFormat != null && !"".equals(strFormat.trim())){
			  return new SimpleDateFormat(strFormat);
		  }else{
			  return new SimpleDateFormat();
		  }
	  }
	  /**
	   * 计算两个日期之间相差的秒
	   * @param date1 
	   * @param date2 
	   * @return 
	   */  
	  public static int misBetween(Date date1,Date date2)  
	  {  
	      Calendar cal = Calendar.getInstance();  
	      cal.setTime(date1);  
	      Long time1 = cal.getTimeInMillis();  
	      cal.setTime(date2);  
	      Long time2 = cal.getTimeInMillis();   
	      Long between_days=(time2-time1)/(1000);    
	     return Integer.parseInt(String.valueOf(between_days));         
	  }
	  public static Date parseDate(String strDate, String format) throws ParseException {
		    return getSimpleDateFormat(format).parse(strDate);
		  }
}
