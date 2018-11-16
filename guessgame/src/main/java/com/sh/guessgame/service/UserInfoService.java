package com.sh.guessgame.service;

import com.sh.guessgame.utils.exception.GameException;

/**
 * 用户服务 
 */
public interface UserInfoService {
	
	/**
	 * 添加用户 
	 */
	public void register(String wechatId) throws GameException;
	
	/**
	 *  登录
	 */
	
	public void login(String wechatId) throws GameException;
	
	/**
	 *  退出
	 */
	
	public void logout(String sessionId) throws GameException;
}
