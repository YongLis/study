package com.sh.guessgame.utils.vo;

import java.io.Serializable;

public class RefundVO implements Serializable{
	private static final long serialVersionUID = -4693162944816855051L;
	private long id; 
	private String bathId; // 批次号
	private String orderId; // 下单号
	private String winnerId; // 批次号
	private String wechatId; // 微信号
	private String currency; // 币种
	private String amount; // 金额
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBathId() {
		return bathId;
	}
	public void setBathId(String bathId) {
		this.bathId = bathId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(String winnerId) {
		this.winnerId = winnerId;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
