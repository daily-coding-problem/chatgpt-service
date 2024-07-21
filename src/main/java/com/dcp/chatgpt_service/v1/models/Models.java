package com.dcp.chatgpt_service.v1.models;

import lombok.Getter;

@Getter
public enum Models {
	GPT3("gpt-3.5-turbo-instruct");

	private final String model;

	Models(String model) {
		this.model = model;
	}
}
