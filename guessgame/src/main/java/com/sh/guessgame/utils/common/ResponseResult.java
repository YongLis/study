/**
 * 
 */
package com.sh.guessgame.utils.common;

import java.util.HashMap;

/**
 * @Description: 返回结果
 * @author Administrator
 * @date:2017年12月19日 下午5:48:32
 * @Version: V1.0
 */
public class ResponseResult extends HashMap<String, Object>{
    private static final long serialVersionUID = 817163186202829237L;
	public static String RETCODE = "retCode";
	public static String RETMSG = "retMsg";
	
    
    private String retCode;
    private Object retMsg;
    
    public ResponseResult(String retCode, Object retMsg){
        super();
        put(RETCODE, retCode);
        put(RETMSG, retMsg);
    }
    public ResponseResult(String  retMsg){
        super();
        put(RETCODE, "99999");
        put(RETMSG, retMsg);
    }
    
    public ResponseResult(){}
    
    public static ResponseResult getSuccessResult(){
        return new ResponseResult(ErrorCode.SYSTEM_SUCCESS.getCode(), ErrorCode.SYSTEM_SUCCESS.getMsg());
    }
    
    public static ResponseResult getSystemBusyResult(){
        return new ResponseResult(ErrorCode.SYSTEM_BUSY.getCode(), ErrorCode.SYSTEM_BUSY.getMsg());
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public Object getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(Object retMsg) {
        this.retMsg = retMsg;
    }

}
