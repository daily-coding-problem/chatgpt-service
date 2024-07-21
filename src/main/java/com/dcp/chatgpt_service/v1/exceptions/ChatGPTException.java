package com.dcp.chatgpt_service.v1.exceptions;

public class ChatGPTException extends RuntimeException {
	public ChatGPTException(String message) {
		super(message);
	}

	public ChatGPTException(String message, Throwable cause) {
		super(message, cause);
	}
}
