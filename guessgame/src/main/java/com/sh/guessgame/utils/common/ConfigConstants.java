package com.sh.guessgame.utils.common;

public class ConfigConstants {
	public static final String DQ_SUCCESS_CODE = "10000";
	// 用户session存在的redis 中的key前缀
	public static final String PREFIX_SESSION_KEY = "session,key,"; 
	// APPID存在的redis 中的key前缀
	public static final String PREFIX_APPID_KEY = "appid,key,"; 
	// APPID异步通知的url前缀
	public static final String PREFIX_NOTIFY_URL = "notify,url,key,";

	// 默认30分钟内连续输错密码N（PWD_ERROR_MAX_COUNT）次，则锁定账户
	public static final int PWD_TIME_WINDOW_DEFAULT = 30;
	// 密码允许错误次数默认值
	public static final int PWD_ERROR_MAX_COUNT_DEFAULT = 5;

    // 交易密码token默认失效（秒）
    public static final long TRADE_PWD_EXPIRETIME_TOKEN_DEFAULT = 300;


	public static final String APPCLIENT_METHOD_PAY="aepay.trade.pay";
	public static final String APPCLIENT_METHOD_CREATE ="aepay.trade.create";
	public static final String APPCLIENT_METHOD_REFUND="aepay.trade.refund";
	public static final String APPCLIENT_METHOD_QUERY="aepay.trade.quary";
	public static final String APPCLIENT_METHOD_WITHDRAW="aepay.trade.withdraw";
	public static final String APPCLIENT_METHOD_WAPPAY="aepay.trade.wap.pay";
	public static final String APPCLIENT_METHOD_DOWNLOADBILL="aepay.trade.downloadBill";
	/** 默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** Date默认时区 **/
	public static final String DATE_TIMEZONE = "GMT+8";

	//交易密码key前缀
	public static final String TRADE_PWD_MODIFYTRADEPWD_TOKEN_PREFIX = "aemoney.sdk.modifytradepwd.token.";

	//未设置交易密码的提示信息
	public static final String PROMPT_ABOUT_NOT_SET_TRADE_PWD = "建议您设置交易密码，提升资金安全》";
	//未若实名认证的提示信息
	public static final String PROMPT_ABOUT_NOT_WEAK_CERTI = "建议您进行身份认证，杜绝资金风险》";

	public static final String CURRENCY_CODE_CNY = "CNY"; //人民币
	// public static final String PREFIX_APP_NO = "0001";
	// public static final String PREFIX_ORDER_NO = "0002";
	// public static final String PREFIX_EACCOUNT_NO = "0003";
	// public static final String PREFIX_EACCOUNT_SUNINFO_NO = "0004";
	// public static final String PREFIX_BANKCARD_NO = "0005";
	// public static final String PREFIX_USER_NO = "0006";
	
	  //发送短信的渠道
    public static final String SMS_CHANNEL_API = "emay";
    //默认的短信渠道(亿美)
    public static final String SMS_CHANNEL_API_DEGAULT = "emay";
	/** UTF-8字符集 **/
	public static final String CHARSET_UTF8 = "UTF-8";

    // 亿美短信客户端序列号
    public static final String SMS_EMAY_SERIALNO = "3SDK-EMY-0130-JIXOT";
    // 亿美短信客户端key
    public static final String SMS_EMAY_KEY = "aemoney";
    // 亿美短信客户端密码
    public static final String SMS_EMAY_PWD = "638482";

    // 短信模板配置项名称
    public static final String SMS_TEMPLATE = "sms.template";
    // 短信重发时间间隔(配置的要比界面设置稍短，主要是防止恶意访问)秒。
    public static final String SMS_RESEND_INTERVAL = "sms.resend_interval";
    public static final long SMS_RESEND_INTERVAL_DEFAULT = 30;
    // 短信验证码有效期（分）
    public static final int SMS_EXPIRED_MINUTES =15;
    public static final int SMS_EXPIRED_MINUTES_DEFAULT = 15;
    // 短信发送时间，缓存键值前缀。
    public static final String SMS_CODE_SEND_TIME = "sendtime,sms,";
    // 短信验证码变量名称
    public static final String PARAM_SMS_CODE = "smscode";
    public static final String PARAM_SMS_EXPIRED_MINUTES = "expired_minutes";
    // Card index prefix
    public static final String CARD_INDEX_PREFIX = "CI_";

    // 测试用短信验证码
    public static final String SMS_TEST_CODE = "sms.testcode";
    public static final String SMS_TEST_CODE_DEFAULT = "999999";

    // 测试短信验证开关
    public static final String SMS_TEST_SWITCH = "sms.test_switch";
    public static final Boolean SMS_TEST_SWITCH_DEFAULT = Boolean.FALSE;

    //天畅短信客户端用户名
    public static final String SMS_TECHOWN_UN = " 800480";
    //天畅短信客户端密码
    public static final String SMS_TECHOWN_PW = "dk38twe7f3";
    //天畅短信客户端  发送短信入口URL
    public static final String SMS_TECHOWN_URL = "http://222.73.44.38:8080/mt";

    //短信模板中的key
    public static final String PREFIX_AEMONEY_SDK = "aemoney.sdk.";
    public static final String EMPTY = "";
    public static final String WX_RETURN_SUCCESS = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    public static final String WX_RETURN_FAIL = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[签名失败]]></return_msg></xml>";
    public static final String ORDER_STATE_TRADE_SUCCESS = "TRADE_SUCCESS";
    public static final String ORDER_STATE_TRADE_FINISHED = "TRADE_FINISHED";
    public static final String ORDER_STATE_SUCCESS = "SUCCESS";
    public static final String ORDER_STATE_FAIL = "FAIL";

    public static final String WX_NOTIFY_URL = "wxpay/notify.htm";
    public static final String ALI_NOTIFY_URL = "alipay/notify.htm";
    public static final String FIELD_NAME_RETURN_CODE = "return_code";
    public static final String FIELD_NAME_ATTACH = "attach";
    public static final String FIELD_NAME_TOTAL_FEE = "total_fee";
    public static final String FIELD_NAME_SIGN = "sign";
    public static final String FIELD_NAME_OUT_TRADE_NO = "out_trade_no";
    public static final String FIELD_NAME_TRADE_NO = "trade_no";
    public static final String FIELD_NAME_TRADE_STATUS = "trade_status";
    public static final String FIELD_NAME_TRANSACTION_ID = "transaction_id";
    public static final String FIELD_NAME_RESULT_CODE = "result_code";
    public static final String FIELD_NAME_PASSBACK_PARAMS = "passback_params";
    public static final String FIELD_NAME_TOTAL_AMOUNT = "total_amount";



    //SDK 验卡
    public static final String SDK_VERIFYCARD_TOKEN = "sdk.verifyCard.token."; //缓存cardModel的前缀
    public static final long SDK_VERIFYCARD_TOKEN_EXPIRETIME_DEFAULT = 300;//缓存cardModel的时间


    //支持的银行列表
    public static final String SUPPORT_BANK_LIST = "support_bank_list";


}
