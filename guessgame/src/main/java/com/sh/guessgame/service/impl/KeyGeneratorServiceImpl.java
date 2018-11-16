package com.sh.guessgame.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.guessgame.service.KeyGeneratorService;
import com.sh.guessgame.utils.dateutil.DateUtil;
import com.sh.guessgame.utils.exception.GameException;
import com.sh.guessgame.utils.redis.RedisCacheTemplate;

@Service
public class KeyGeneratorServiceImpl implements KeyGeneratorService {
	private static final String USER_ID_KEY = "user_id";
	private static final String ORDER_ID_KEY = "order_id";
	private static final String TRADE_ID_KEY = "trade_id";
	private static final String BATCH_ID_KEY = "batch_id";
	
	
	@Autowired
	private RedisCacheTemplate redisCacheTemplate;
	@Override
	public String getUserId() throws GameException {
		long value = redisCacheTemplate.incr(USER_ID_KEY);
		return DateUtil.getCurrentDate(DateUtil.YYMMDDHHMMSSSSS)+value;
	}

	@Override
	public String getOrderId() throws GameException {
		long value = redisCacheTemplate.incr(ORDER_ID_KEY);
		return DateUtil.getCurrentDate(DateUtil.YYMMDDHHMMSSSSS)+value;
	}

	@Override
	public String getTradeId() throws GameException {
		long value = redisCacheTemplate.incr(TRADE_ID_KEY);
		return DateUtil.getCurrentDate(DateUtil.YYMMDDHHMMSSSSS)+value;
	}

	@Override
	public String getBatchId() throws GameException {
		long value = redisCacheTemplate.incr(BATCH_ID_KEY);
		return DateUtil.getCurrentDate(DateUtil.YYMMDDHHMMSSSSS)+value;
	}
}
