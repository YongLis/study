package com.sh.guessgame.service;

import com.sh.guessgame.utils.exception.GameException;

/**
 * 退款服務 
 */
public interface RefundService {
	/**
	 * 退款 
	 */
	public void refund() throws  GameException;
}
