package com.dcp.chatgpt_service.v1.controllers;

import com.dcp.chatgpt_service.v1.models.ChatRequest;
import com.dcp.chatgpt_service.v1.models.ChatResponse;
import com.dcp.chatgpt_service.v1.services.ChatGPTService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ChatGPTControllerImplTest {

	@Mock
	private ChatGPTService chatGPTService;

	@InjectMocks
	private ChatGPTControllerImpl chatGPTController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testSendMessage() {
		when(chatGPTService.sendMessage(any(String.class))).thenReturn("Test response");

		ResponseEntity<String> response = chatGPTController.sendMessage("Test message");
		assertEquals("Test response", response.getBody());
	}

	@Test
	public void testSendChatRequest() {
		ChatRequest chatRequest = new ChatRequest();
		ChatResponse chatResponse = new ChatResponse();

		when(chatGPTService.sendChatRequest(any(ChatRequest.class))).thenReturn(chatResponse);

		ResponseEntity<ChatResponse> response = chatGPTController.sendChatRequest(chatRequest);
		assertEquals(chatResponse, response.getBody());
	}
}
