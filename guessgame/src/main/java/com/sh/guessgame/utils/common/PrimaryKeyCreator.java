package com.sh.guessgame.utils.common;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 主键生成器 
 */
public class PrimaryKeyCreator {
    public static long autoCreate(){
        return Long.valueOf(System.currentTimeMillis()+RandomStringUtils.randomNumeric(4));
    }
}
