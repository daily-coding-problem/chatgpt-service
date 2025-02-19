package com.dcp.chatgpt_service.v1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Usage {
	@JsonProperty("prompt_tokens")
	private Integer promptTokens;

	@JsonProperty("completion_tokens")
	private Integer completionTokens;

	@JsonProperty("total_tokens")
	private Integer totalTokens;
}
