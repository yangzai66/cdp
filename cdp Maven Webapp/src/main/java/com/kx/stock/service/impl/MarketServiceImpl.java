package com.kx.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.stock.service.IMarketService;

@Service("marketService")
public class MarketServiceImpl implements IMarketService{
	@Autowired
	IMetadataService metadataService;

	@Override
	public JSONObject list() {
		return null;
	}

}
