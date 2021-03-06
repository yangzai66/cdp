package com.kx.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.kx.stock.cache.IStCache;
import com.kx.stock.reptile.MarketReptile;
import com.kx.stock.reptile.StockTask;
import com.kx.sys.service.ICacheService;
 
public class SpringContextHolder implements ApplicationContextAware  {
	private static ApplicationContext applicationContext;
	@Autowired
	ICacheService cacheService;
	@Autowired
	IStCache stCache;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
		cacheService.loadCache();
		stCache.loadCache();
		StockTask stockTask = new StockTask();
		Thread thread = new Thread(stockTask);
		thread.start();
//		MarketReptile  marketReptile = new MarketReptile();
//		Thread market_thread = new Thread(marketReptile);
//		market_thread.start();
	}
	/**
	* ȡ�ô洢�ھ�̬�����е�ApplicationContext.
	*/
	public static ApplicationContext getApplicationContext() {
	checkApplicationContext();
	return applicationContext;
	}

	/**
	* �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
	checkApplicationContext();
	return (T) applicationContext.getBean(name);
	}

	/**
	* �Ӿ�̬����ApplicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
	*/
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
	checkApplicationContext();
	return (T) applicationContext.getBeansOfType(clazz);
	}

	/**
	* ���applicationContext��̬����.
	*/
	public static void cleanApplicationContext() {
	applicationContext = null;
	}

	private static void checkApplicationContext() {
	if (applicationContext == null) {
	throw new IllegalStateException("applicaitonContextδע��,����applicationContext.xml�ж���SpringContextHolder");
	}
	}
	
}
