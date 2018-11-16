package com.sh.guessgame.utils.common;


import java.util.Random;

public class SystemIDGenerator {
    private Random random = new Random();
    private String table = "0123456789";
    private static SystemIDGenerator bPIDGenerator = new SystemIDGenerator();

    private SystemIDGenerator() {
    }

    public static SystemIDGenerator getInstance() {
        return bPIDGenerator;
    }

    /**
     * src小于minlength等于minlength; src长度高于minlength,等于src长度
     *
     * @param src
     * @param minlength 最小长度
     * @return
     */
    public String newRandomID(long src, int minlength) {
        String ret = null, num = String.format("%0" + minlength + "d", src);
        int key = random.nextInt(10), seed = random.nextInt(100);
        Caesar caesar = new Caesar(table, seed);
        num = caesar.encode(key, num);
        ret = num;
        return ret;
    }

    /**
     *
     * @param id 序列值
     * @return
     */
    public String getGenerateNo(Long id, String prefix) {
//        String currentDate = DateUtil.getCurrentDate(DateUtil.YYYYMMDDHHMMSS);
        StringBuilder buId = new StringBuilder();
        // 时间+线程
//        buId.append(currentDate).append(Thread.currentThread().getId());
        buId.append(prefix).append("0000").append(id);
        String random = newRandomID(id, 4);// 通过id生成4为随机数
        buId.append(random);
        int check = HashIndexUtil.getCheckCode(buId.toString());// 1位校验码
        buId.append(check);
        return buId.toString();
    }
   

}

class Vigenere {
    private String table;
    private int seedA = 1103515245;
    private int seedB = 12345;

    public Vigenere(String table, int seed) {
        this.table = chaos(table, seed, table.length());
    }

    public Vigenere(String table) {
        this(table, 11);
    }

    public Vigenere() {
        this(11);
    }

    public Vigenere(int seed) {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", seed);
    }

    private char dict(int i, boolean reverse) {
        int s = table.length(), index = reverse ? s - i : i;
        return table.charAt(index);
    }

    private int dict(char c, boolean reverse) {
        int s = table.length(), index = table.indexOf(c);
        return reverse ? s - index : index;
    }

    private int seed(int seed) {
        long temp = seed;
        return (int) ((temp * seedA + seedB) & 0x7fffffffL);
    }

    public String chaos(String data, int seed, int cnt) {
        StringBuffer buf = new StringBuffer(data);
        char tmp;
        int a, b, r = data.length();
        for (int i = 0; i < cnt; i += 1) {
            seed = seed(seed);
            a = seed % r;
            seed = seed(seed);
            b = seed % r;
            tmp = buf.charAt(a);
            buf.setCharAt(a, buf.charAt(b));
            buf.setCharAt(b, tmp);
        }
        return buf.toString();
    }

    public String crypto(boolean reverse, String key, String text) {
        String ret = null;
        StringBuilder buf = new StringBuilder();
        int m, k, s = table.length(), e = text.length(), ke = key.length();

        for (int i = 0; i < e; i += 1) {
            m = dict(text.charAt(i), reverse);
            k = dict(key.charAt(i % ke), false);
            if (m < 0 || k < 0)
                break;
            m = m + k + i;
            buf.append(dict(m % s, reverse));
        }
        if (buf.length() == e)
            ret = buf.toString();
        return ret;
    }

    public String encode(String key, String text) {
        return crypto(false, key, text);

    }

    public String decode(String key, String text) {
        return crypto(true, key, text);
    }

}

class Caesar {
    private String table;
    private int seedA = 1103515245;
    private int seedB = 12345;

    public Caesar(String table, int seed) {
        this.table = chaos(table, seed, table.length());
    }

    public Caesar(String table) {
        this(table, 11);
    }

    public Caesar() {
        this(11);
    }

    public Caesar(int seed) {
        this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", seed);
    }

    public char dict(int i, boolean reverse) {
        int s = table.length(), index = reverse ? s - i : i;
        return table.charAt(index);
    }

    public int dict(char c, boolean reverse) {
        int s = table.length(), index = table.indexOf(c);
        return reverse ? s - index : index;
    }

    public int seed(int seed) {
        long temp = seed;
        return (int) ((temp * seedA + seedB) & 0x7fffffffL);
    }

    public String chaos(String data, int seed, int cnt) {
        StringBuffer buf = new StringBuffer(data);
        char tmp;
        int a, b, r = data.length();
        for (int i = 0; i < cnt; i += 1) {
            seed = seed(seed);
            a = seed % r;
            seed = seed(seed);
            b = seed % r;
            tmp = buf.charAt(a);
            buf.setCharAt(a, buf.charAt(b));
            buf.setCharAt(b, tmp);
        }
        return buf.toString();
    }

    public String crypto(boolean reverse, int key, String text) {
        String ret = null;
        StringBuilder buf = new StringBuilder();
        int m, s = table.length(), e = text.length();

        for (int i = 0; i < e; i += 1) {
            m = dict(text.charAt(i), reverse);
            if (m < 0)
                break;
            m = m + key + i;
            buf.append(dict(m % s, reverse));
        }
        if (buf.length() == e)
            ret = buf.toString();
        return ret;
    }

    public String encode(int key, String text) {
        return crypto(false, key, text);

    }

    public String decode(int key, String text) {
        return crypto(true, key, text);
    }
}
