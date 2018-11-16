package com.sh.guessgame.utils.common;

import java.util.HashMap;
import java.util.Map;

public enum PrefixOfSystemID {

    MERCHANT_NO("001", "merchantNo"),

	ORDER_NO("002", "orderNo"),

	EACCOUNT_NO("003", "eaccountNo"),

	EACCOUNT_SUBINFO_NO("004", "eaccountSubinfoNo"),

	BANKCARD_NO("005", "bankcardNo"),

	USER_NO("006", "userNo"),
	
	SYSTEM_TRADE_SEQUENCE("007", "systemTradeSequence"),

	CHANNEL_TRADE_SEQUENCE("008", "channelTradeSequence");
    private String code;

    private String name;

    private PrefixOfSystemID(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final Map<String, PrefixOfSystemID> map = new HashMap<String, PrefixOfSystemID>();
    static {
        for (PrefixOfSystemID typeEnum : values()) {
            map.put(typeEnum.getCode(), typeEnum);
        }
    }

    public static PrefixOfSystemID byCode(String code) {
        return map.get(code);
    }
}
