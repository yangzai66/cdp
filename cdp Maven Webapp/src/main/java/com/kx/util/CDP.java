package com.kx.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
/**
 * 系统缓存类
 * @author yang
 *
 */
public class CDP {
	public static JSONObject tableColumns = new JSONObject(); // 数据库表结构 
	public static JSONObject dictionaryJson = new JSONObject();  // 系统数据字典
	public static JSONObject menuJson = new JSONObject();  // 系统菜单
}
