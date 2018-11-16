package com.sh.guessgame.utils.enums;

public enum ErrorCode {
	SYSTEM_SUCCESS("10000","成功"),
	SYSTEM_FAILED("20000","失败"),
	
	// 用户
	USER_NAME_OR_PASSWORD_ERROR("30000","登录名或者密码错误"),
	USER_NAME_EXISTED("30001","登录名已存在"),
	USER_NAME_NOT_NULL("30002","登录名不允许为空"),
	PASSWORD_NOT_NULL("30003","密码不允许为空"),
	SESSION_TIME_OUT("30010","session已过期，请重新登录"),
	SESSION_ID_NOT_NULL("30011","sessionId不允许为空"),
	
	USER_INFO_NOT_EXIST("40001","用户信息不存在"),
	
	
	DB_INSERT_ERROR("90000","数据插入失败"),
	DB_UPDATE_ERROR("90001","数据更新失败"),
	DB_QUERY_ERROR("90002","数据查询失败"),
	DB_DELETE_ERROR("90003","数据删除失败"),
	
	SYSTEM_ERROR("99999","系统错误，请稍后重试");
	private String retCode;
	private String retMsg;
	
	ErrorCode(String retCode, String retMsg){
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

}
