package com.dcp.chatgpt_service.v1.models.image;

import lombok.Getter;

@Getter
public enum ImageSize {
	SMALL("256x256"),
	MEDIUM("512x512"),
	LARGE("1024x1024");

	private final String size;

	ImageSize(String size) {
		this.size = size;
	}
}
