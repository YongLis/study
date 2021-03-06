package com.sh.guessgame.utils.common;

/**
 * Created by daqian on 2017/4/5.
 */
public class HashIndexUtil {
    /**
     * Hash传入的值并返回Hash过后的值
     * @return
     */
    public static String getHashIndex(String cardNo){
        return MD5Util.md5(cardNo);
    }
    /**
     * 得到校验码
     * @param src
     * @return
     */
    public static int getCheckCode(String src){
        int check = 0;//1位校验码
        for(int i=0;src.length()>i;i++){
            check=check+Integer.parseInt(src.charAt(i)+"");
            if(check>=10){
                check= check%10;
            }
        }
        return check;
    }

    /**
     * 传入卡号，返回卡索引
     * @param cardNo
     * @return
     */
    public static String genCardIndex(String cardNo) {
        return ConfigConstants.CARD_INDEX_PREFIX + getHashIndex(cardNo);
    }

}