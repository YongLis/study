package com.sh.guessgame.controller;

import com.sh.guessgame.utils.common.HttpClientUtil;

public class TestMain {

	public static void main(String[] args) {
		HttpClientUtil httpClientUtil = new HttpClientUtil();
		String message = httpClientUtil.doGet("https://t.aemoney.com/aemoney/api/status", null);
		System.out.println(message);
		
	}

}
