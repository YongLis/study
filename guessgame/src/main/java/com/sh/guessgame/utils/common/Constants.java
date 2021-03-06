package com.sh.guessgame.utils.common;

public class Constants {
	public static final String REDIS_NULL_VALUE = "1";

	public static final Long REDIS_TIME_OUT = 60l;

	public static final String EMPTY = "empty:";
	
	public static final String FORCE_LOGIN_OUT_KEY = "force_loginout:";

	public static final String SELLER_ID = "sellerId:detail:";
	
	public static final String DEVICE_ID = "deviceId:detail:";
	
	public static final String USER_DEVICE_ID = "sellerId:devices:";
	
	public static final String USER_ACCESS_ID = "sellerIdAccessId:detail:";
	
	public static final String USER_DEFAULT_ID = "sellerIdDefaultId:detail:";
	
	public static final String USER_TIMEKEEPER_ID = "sellerIdTimeKeeperId:detail:";
	
	public static final String USER_CERT_ID = "sellerIdCertId:detail:";
	
	public static final String QRCODE_ID = "qrcode:detail:";

	public static final String NEW_TOPIC_MESSAGE = "newTopicMessage:detail:";
	
	public static final String SELLER_LOGIN_TOKEN = "sellerLoginToken:";

    public static final String VER_CODE = "verCode:";
    
    public static final String SMS_CODE = "999999";
        
    public static final String SELLER_LOGIN_LOCK = "sellerLoginLock:"; //锁定标识，1代表锁定，0未锁定  (5分钟内连续)
    
    public static final String SELLER_LOGIN_NUM = "sellerLoginNum:";//登陆次数
    
    public static final String SELLER_LOGIN_TIME = "sellerLoginTime:";//登陆时间
    
    public static final String SELLER_LOGIN_LOCK_OUT_TIME = "sellerLoginOutTime:";//锁定失效时间24小时
    
    public static final String SELLER_TOTAL_SALE_AMOUNT = "sellTotalSaleAmount:";//商户总销售额
    
    public static final String CUSTOMER_ID = "customerId:";
    
    public static final String CARD_NO = "card_no:";
    
    public static final String SEND_MESSAGE_TIME = "sendMessageTime:";//发送短信时间
    
    public static final String SEND_MESSAGE_NUM = "sendMessageNum:";//发送短信数量
    
    public static final String SEND_MESSAGE_LOCK_OUT_TIME = "sendMessageLockTime:";//发送短信锁定时间
    
    public static final String WX_SIGN_TYPE_MD5 = "MD5";    // 微信Md5签名
    public static final String WX_SIGN_TYPE_HMAC_SHA256 = "HMAC-SHA256";    // 微信Md5签名
    
    // 支付方式
    public static final String PAY_TYPE_WECHAT_PAY = "wechatPay";    // 微信支付
    public static final String PAY_TYPE_ALI_PAY = "aliPay";    // 支付宝支付
    public static final String PAY_TYPE_BANKCARD_PAY = "bankcardPay";    // 银行卡支付
    public static final String PAY_TYPE_BALANCE_PAY = "balancePay";    // 余额支付
    
    // 交易类型
    public static final String TRANS_TYPE_RECHARGE = "recharge";    // 充值
    public static final String TRANS_TYPE_WITHDRAW = "withdraw";    // 提现
    public static final String TRANS_TYPE_PAY = "pay";    // 支付
    public static final String TRANS_TYPE_REFUND = "refund";    // 退款
    
}
