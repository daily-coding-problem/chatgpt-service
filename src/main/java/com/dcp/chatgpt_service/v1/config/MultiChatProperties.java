package com.dcp.chatgpt_service.v1.config;

import com.dcp.chatgpt_service.v1.models.Models;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MultiChatProperties {

	private String url = "https://api.openai.com/v1/chat/completions";

	private String model = Models.GPT3.getModel();

	private Integer maxTokens = 500;

	private Double temperature = 1.0;

	private Double topP = 1.0;

}
