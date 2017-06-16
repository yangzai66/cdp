package com.kx.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;
import com.kx.listener.SpringContextHolder;
import com.kx.metadata.service.IMetadataService;
import com.kx.sys.service.IUserService;
import com.kx.util.JsonUtil;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject login(JSONObject dataJson) {
		JSONObject result = JsonUtil.resultData();
		List<Map<String, Object>> userList =metadataService.queryForList("SELECT * FROM USER_RECORD WHERE USER_NAME='"+dataJson.getString("username")+"' AND PASSWORD='"+dataJson.getString("password")+"'"); 
		if(userList.size()>0){
			result.put("data", userList.get(0));
			return result;
		}else{
			result.put("result", false);
		}
		return result;
	}

}
