package com.dcp.chatgpt_service.v1.controllers;

import com.dcp.chatgpt_service.v1.models.ChatRequest;
import com.dcp.chatgpt_service.v1.models.ChatResponse;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatMessage;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatRequest;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatResponse;
import com.dcp.chatgpt_service.v1.models.image.ImageFormat;
import com.dcp.chatgpt_service.v1.models.image.ImageSize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chatgpt")
public interface ChatGPTController {

	@PostMapping("/sendMessage")
	ResponseEntity<String> sendMessage(@RequestBody String message);

	@PostMapping("/sendChatRequest")
	ResponseEntity<ChatResponse> sendChatRequest(@RequestBody ChatRequest chatRequest);

	@PostMapping("/multiChat")
	ResponseEntity<String> multiChat(@RequestBody List<MultiChatMessage> messages);

	@PostMapping("/multiChatRequest")
	ResponseEntity<MultiChatResponse> multiChatRequest(@RequestBody MultiChatRequest multiChatRequest);

	@PostMapping("/generateImage")
	ResponseEntity<String> generateImage(@RequestBody String prompt);

	@PostMapping("/generateImages")
	ResponseEntity<List<String>> generateImages(@RequestParam String prompt,
												@RequestParam Integer n,
												@RequestParam ImageSize size,
												@RequestParam ImageFormat format);
}
