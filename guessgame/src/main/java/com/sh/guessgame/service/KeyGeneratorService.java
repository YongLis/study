package com.sh.guessgame.service;


/**
 * 主键生成器 
 */
public interface KeyGeneratorService {
	public String getUserId() throws Exception;
	
	public String getOrderId() throws Exception;
	
	public String getTradeId() throws Exception;
	
	public String getBatchId() throws Exception;
	
//	public String getWinnerId() throws GameException;
	
}
