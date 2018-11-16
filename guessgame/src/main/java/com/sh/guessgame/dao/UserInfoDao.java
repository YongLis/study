package com.sh.guessgame.dao;

import com.sh.guessgame.mybatis.model.UserInfo;
import com.sh.guessgame.utils.exception.GameException;

public interface UserInfoDao {

	/**
	 * 增 
	 */
	public int inserUserInfo(UserInfo record) throws GameException; 
	
	/**
	 * 根据主键删除
	 */
	public int deleteByPrimaryKey(long  id) throws GameException;
	
	/**
	 * 根据userId删除
	 */
	public int deleteByUserId(String userId) throws GameException;
	
	/**
	 * 更新
	 */
	public int updateUserInfo(UserInfo record) throws GameException;
	
	/**
	 * 根据主键查询
	 */
	public UserInfo selectById(long id) throws GameException;
	
	/**
	 * 根据userId查询
	 */
	public UserInfo selectByUserId(String userId) throws GameException;
	
	
}
