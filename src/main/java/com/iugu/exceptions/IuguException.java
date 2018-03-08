package com.iugu.exceptions;

public class IuguException extends Exception {
	private static final long serialVersionUID = 8701207870125630038L;
	private final String responseMessage;
	private final int status;

	public IuguException(String Message, int ResponseCode, String ResponseText) {
		super(Message + " - StatusCode: [" + ResponseCode + "] / ResponseText: [" + ResponseText + "]");
		responseMessage = ResponseText;
		status = ResponseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public int getStatus() {
		return status;
	}
}
