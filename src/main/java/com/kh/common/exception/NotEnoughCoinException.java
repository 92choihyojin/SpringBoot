package com.kh.common.exception;

public class NotEnoughCoinException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotEnoughCoinException(String msg) {
		super(msg);
	}
}