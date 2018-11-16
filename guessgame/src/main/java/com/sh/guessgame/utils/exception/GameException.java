package com.sh.guessgame.utils.exception;

import com.sh.guessgame.utils.enums.ErrorCode;

public class GameException extends RuntimeException{


	private static final long serialVersionUID = -7899489896265089938L;
	protected String errorCode;

	public GameException() {
	}

	public GameException(String message) {
		super(message);
	}

	public GameException(Throwable cause) {
		super(cause);
	}

	public GameException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public GameException(Throwable cause, String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
	public GameException(String errorCode, String message, String... args ) {
        super(String.format(message, args));
        this.errorCode = errorCode;
    }
	

	public GameException(String message, Throwable cause) {
		super(message, cause);
	}

	public GameException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	public GameException(ErrorCode error) {
		super(error.getRetMsg());
		this.errorCode=error.getRetCode();
	}
	public String getErrorCode() {
		return this.errorCode;
	}

}
