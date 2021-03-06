package com.sh.guessgame.utils.common;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by daqian on 2017/4/5.
 */
public class MD5Util {
    private static final Logger logger       = LoggerFactory.getLogger(MD5Util.class);

    public static char          HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'    };

    public static String md5(String data) {
        try {
            return md5(data.getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error("md5 exception",e);
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(md5("5124250100012104"));
        System.out.println("318d60cd2654e96dca11bd4434d0c639");
    }

    public static String md5(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(bytes);
            byte[] digest = md.digest();
            int j = digest.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = digest[i];
                str[k++] = HEX_DIGITS[b >> 4 & 0xf];
                str[k++] = HEX_DIGITS[b & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            logger.error("get md5 exception", e);
            return null;
        }
    }

}
