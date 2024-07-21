package com.dcp.chatgpt_service.v1.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Choice {
	private String text;
	private Integer index;
	private String logprobs;

	@JsonProperty("finish_reason")
	private String finishReason;
}
