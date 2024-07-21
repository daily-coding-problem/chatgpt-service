package com.dcp.chatgpt_service.v1.controllers;

import com.dcp.chatgpt_service.v1.models.ChatRequest;
import com.dcp.chatgpt_service.v1.models.ChatResponse;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatMessage;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatRequest;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatResponse;
import com.dcp.chatgpt_service.v1.models.image.ImageFormat;
import com.dcp.chatgpt_service.v1.models.image.ImageSize;
import com.dcp.chatgpt_service.v1.services.ChatGPTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class ChatGPTControllerImpl implements ChatGPTController {

	private final ChatGPTService chatGPTService;

	public ChatGPTControllerImpl(ChatGPTService chatGPTService) {
		this.chatGPTService = chatGPTService;
	}

	@Override
	public ResponseEntity<String> sendMessage(@RequestBody String message) {
		return ResponseEntity.ok(chatGPTService.sendMessage(message));
	}

	@Override
	public ResponseEntity<ChatResponse> sendChatRequest(@RequestBody ChatRequest chatRequest) {
		return ResponseEntity.ok(chatGPTService.sendChatRequest(chatRequest));
	}

	@Override
	public ResponseEntity<String> multiChat(@RequestBody List<MultiChatMessage> messages) {
		return ResponseEntity.ok(chatGPTService.multiChat(messages));
	}

	@Override
	public ResponseEntity<MultiChatResponse> multiChatRequest(@RequestBody MultiChatRequest multiChatRequest) {
		return ResponseEntity.ok(chatGPTService.multiChatRequest(multiChatRequest));
	}

	@Override
	public ResponseEntity<String> generateImage(@RequestBody String prompt) {
		return ResponseEntity.ok(chatGPTService.generateImage(prompt));
	}

	@Override
	public ResponseEntity<List<String>> generateImages(@RequestParam String prompt,
													   @RequestParam Integer n,
													   @RequestParam ImageSize size,
													   @RequestParam ImageFormat format) {
		return ResponseEntity.ok(chatGPTService.generateImage(prompt, n, size, format));
	}
}
