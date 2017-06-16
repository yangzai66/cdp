package com.kx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
	/**ȱʡ���ڸ�ʽ*/
	  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	  
	  /**ȱʡʱ���ʽ*/
	  public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	  /**ȱʡ�¸�ʽ*/
	  public static final String DEFAULT_MONTH = "MONTH";

	  /**ȱʡ���ʽ*/
	  public static final String DEFAULT_YEAR = "YEAR";

	  /**ȱʡ�ո�ʽ*/
	  public static final String DEFAULT_DATE = "DAY";

	  /**ȱʡСʱ��ʽ*/
	  public static final String DEFAULT_HOUR = "HOUR";
	  
	  /**ȱʡ���Ӹ�ʽ*/
	  public static final String DEFAULT_MINUTE = "MINUTE";
	  
	  /**ȱʡ���ʽ*/
	  public static final String DEFAULT_SECOND = "SECOND";
	  
	  /**ȱʡ�����ڸ�ʽ*/
	  public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH-mm";

	  /**ȱʡ�����ڸ�ʽ,��ȷ����*/
	  public static final String DEFAULT_DATETIME_FORMAT_SEC = "yyyy-MM-dd HH:mm:ss";

	  /**��������*/
	  public static final String[] WEEKS = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};
	  
	  public static String getCurDate(String format){
		  return getSimpleDateFormat(format).format(new Date());
	  }
	  /**
	   * ��ȡ��ʽ������
	   * @param strFormat ��ʽ���ĸ�ʽ ��"yyyy-MM-dd"
	   * @return ��ʽ������
	   */
	  public static SimpleDateFormat getSimpleDateFormat(String strFormat){
		  if(strFormat != null && !"".equals(strFormat.trim())){
			  return new SimpleDateFormat(strFormat);
		  }else{
			  return new SimpleDateFormat();
		  }
	  }
	  /**
	   * ������������֮��������
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
