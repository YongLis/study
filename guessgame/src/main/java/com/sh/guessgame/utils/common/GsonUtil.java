package com.sh.guessgame.utils.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Description: Gson工具类
 * @Author: liyong
 * @date: 2017年12月4日 下午8:52:14 
 * @Version: V1.0
 */
public class GsonUtil {
    /**
     * 对象转字符串 
     */
    public static String ObjectToString(Object object){
        if(object == null){
            return null;
        }
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(object);
    }
    
}
