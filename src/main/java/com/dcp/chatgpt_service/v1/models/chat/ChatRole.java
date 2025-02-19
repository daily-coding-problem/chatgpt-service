package com.dcp.chatgpt_service.v1.models.chat;

import lombok.Getter;

@Getter
public enum ChatRole {
	SYSTEM("system"),
	USER("user"),
	ASSISTANT("assistant");

	private final String role;

	ChatRole(String role) {
		this.role = role;
	}
}
