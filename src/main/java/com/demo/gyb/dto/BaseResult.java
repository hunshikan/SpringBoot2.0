package com.demo.gyb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class BaseResult {
	private int result;
	private String message;
	private Map<String, Object> data;

	public BaseResult() {
	}

	public BaseResult(int resultCode, String message) {
		this.setResult(resultCode);
		this.setMessage(message);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
