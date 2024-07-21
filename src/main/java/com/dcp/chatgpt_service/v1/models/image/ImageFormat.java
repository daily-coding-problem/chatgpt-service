package com.dcp.chatgpt_service.v1.models.image;

import lombok.Getter;

@Getter
public enum ImageFormat {
	URL("url"),BASE64("b64_json");

	private final String format;

	ImageFormat(String format) {
		this.format = format;
	}
}
