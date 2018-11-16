package com.sh.guessgame.utils.common;

/**
 * Created by wangqian on 2017/5/31.
 */
public class TextUtil {
    /**
     * 对message中的信息替换，只保留前 一部分和后一部分，
     * 消息长度小于等于 prefixCount + suffixCount 时不做处理
     * @param message
     * @param prefixCount 前面要保留的位数
     * @param suffixCount 后面要保留的位数
     * @return
     */
    public static String ReplaceNumber(String message, int prefixCount, int suffixCount) {

        if (StringUtil.isEmpty(message) || message.length() <= (prefixCount + suffixCount)) {
            return message;
        }

        int length = message.length();
        int stayNum = prefixCount + suffixCount;
        int count = length - stayNum;
        String str = "";

        for (int i = 0; i < count; i++) {
            str = str + "*";
        }

        return message.substring(0, prefixCount) + str
                + message.substring(length - suffixCount);
    }

    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equals(str2);
    }
}
