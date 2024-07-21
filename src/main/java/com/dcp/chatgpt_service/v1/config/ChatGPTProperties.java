package com.dcp.chatgpt_service.v1.config;

import com.dcp.chatgpt_service.v1.models.Models;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "chatgpt")
public class ChatGPTProperties {
	private String apiKey = "";

	private String url = "https://api.openai.com/v1/completions";

	private String model = Models.GPT3.getModel();

	private Integer maxTokens = 500;

	private Double temperature = 1.0;

	private Double topP = 1.0;

	private MultiChatProperties multi;

	private ImageProperties image;

	public ChatGPTProperties() {
		this.multi = new MultiChatProperties();
		this.image = new ImageProperties();
	}
}
