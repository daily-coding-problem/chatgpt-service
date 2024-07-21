package com.dcp.chatgpt_service.v1.controllers;

import com.dcp.chatgpt_service.v1.models.ChatRequest;
import com.dcp.chatgpt_service.v1.models.ChatResponse;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatMessage;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatRequest;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatResponse;
import com.dcp.chatgpt_service.v1.models.image.ImageFormat;
import com.dcp.chatgpt_service.v1.models.image.ImageSize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ChatGPTController {

	ResponseEntity<String> sendMessage(@RequestBody String message);

	ResponseEntity<ChatResponse> sendChatRequest(@RequestBody ChatRequest chatRequest);

	ResponseEntity<String> multiChat(@RequestBody List<MultiChatMessage> messages);

	ResponseEntity<MultiChatResponse> multiChatRequest(@RequestBody MultiChatRequest multiChatRequest);

	ResponseEntity<String> generateImage(@RequestBody String prompt);

	ResponseEntity<List<String>> generateImages(@RequestParam String prompt,
												@RequestParam Integer n,
												@RequestParam ImageSize size,
												@RequestParam ImageFormat format);
}
