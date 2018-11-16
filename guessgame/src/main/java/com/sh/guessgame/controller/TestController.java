package com.sh.guessgame.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.guessgame.utils.common.IpAddressUtil;
import com.sh.guessgame.utils.redis.RedisCacheTemplate;

@RestController
public class TestController {
	@Autowired
	private RedisCacheTemplate redisCacheTemplate;
	@RequestMapping("/test")
	public String test(HttpServletRequest request){
		System.out.println("ip="+IpAddressUtil.getIpAdrress(request)+", port="+request.getRemotePort());
		
		return "success";
	}
}
