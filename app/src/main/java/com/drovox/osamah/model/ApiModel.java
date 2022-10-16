package com.drovox.osamah.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiModel <T>{

	private T response;
	private String error;

	public ApiModel(T response) {
		this.response = response;
	}

	public ApiModel(String error) {
		this.error = error;
	}

	public T getResponse() {
		return response;
	}

	public String getError() {
		return error;
	}
}