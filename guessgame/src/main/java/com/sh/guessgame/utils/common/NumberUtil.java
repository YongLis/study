package com.sh.guessgame.utils.common;

import java.math.BigDecimal;

public class NumberUtil {
	public static String centToYuan(long cent) {
		BigDecimal bd = new BigDecimal(cent);
		return bd.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP).toString();
	}
}
