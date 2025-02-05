package com.dcp.chatgpt_service.v1.models.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiChatMessage {
	private ChatRole role;
	private String content;
}
