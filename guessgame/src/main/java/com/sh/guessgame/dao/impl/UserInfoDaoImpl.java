package com.sh.guessgame.dao.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.guessgame.dao.UserInfoDao;
import com.sh.guessgame.mybatis.mapper.UserInfoMapper;
import com.sh.guessgame.mybatis.model.UserInfo;
import com.sh.guessgame.service.KeyGeneratorService;
import com.sh.guessgame.utils.enums.ErrorCode;
import com.sh.guessgame.utils.exception.GameException;

@Service
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	private static Logger logger = LoggerFactory
			.getLogger(UserInfoDaoImpl.class);
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private KeyGeneratorService keyGeneratorService;

	@Override
	public int inserUserInfo(UserInfo record) throws GameException {
		try {
			if (record != null) {
				record.setUserId(keyGeneratorService.getUserId());
				record.setGmtCreate(new Date());
				return userInfoMapper.insertSelective(record);
			}
		} catch (Exception e) {
			logger.error("insert userinfo error", e);
			throw new GameException(ErrorCode.DB_INSERT_ERROR);
		}
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(long id) throws GameException {
		try {
			UserInfo userInfo = new UserInfo();
			userInfo.setId(id);
			userInfo.setState("-1");
			userInfo.setGmtModify(new Date());
			return userInfoMapper.updateByPrimaryKeySelective(userInfo);
		} catch (Exception e) {
			logger.error("delete userinfo error", e);
			throw new GameException(ErrorCode.DB_INSERT_ERROR);
		}
	}

	@Override
	public int deleteByUserId(String userId) throws GameException {
		try {
			UserInfo userInfo = selectByUserId(userId);
			if (userInfo != null) {
				UserInfo tmpInfo = new UserInfo();
				tmpInfo.setId(userInfo.getId());
				userInfo.setState("-1");
				userInfo.setGmtModify(new Date());
				return userInfoMapper.updateByPrimaryKeySelective(userInfo);
			}
		} catch (Exception e) {
			logger.error("delete userinfo error", e);
			throw new GameException(ErrorCode.DB_DELETE_ERROR);
		}
		return 0;
	}

	@Override
	public int updateUserInfo(UserInfo record) throws GameException {
		try{
			return userInfoMapper.updateByPrimaryKey(record);
			
		} catch (Exception e) {
			logger.error("update userinfo error", e);
			throw new GameException(ErrorCode.DB_UPDATE_ERROR);
		}
	}

	@Override
	public UserInfo selectById(long id) throws GameException {
		try{
			return userInfoMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("select userinfo error", e);
			throw new GameException(ErrorCode.DB_QUERY_ERROR);
		}
	}

	@Override
	public UserInfo selectByUserId(String userId) throws GameException {
		try{
			return userInfoMapper.selectByUserId(userId);
		} catch (Exception e) {
			logger.error("select userinfo error", e);
			throw new GameException(ErrorCode.DB_QUERY_ERROR);
		}
	}

}
