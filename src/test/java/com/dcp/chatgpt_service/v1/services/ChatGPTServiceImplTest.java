package com.dcp.chatgpt_service.v1.services;

import com.dcp.chatgpt_service.v1.config.ChatGPTProperties;
import com.dcp.chatgpt_service.v1.models.ChatResponse;
import com.dcp.chatgpt_service.v1.models.Choice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.http.HttpEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ChatGPTServiceImplTest {

	@Mock
	private ChatGPTProperties chatGPTProperties;

	@Mock
	private ChatGPTRestClient chatGPTRestClient;

	@InjectMocks
	private ChatGPTServiceImpl chatGPTServiceImpl;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		// Mock all the properties used in the service
		when(chatGPTProperties.getApiKey()).thenReturn("fake-api-key");
		when(chatGPTProperties.getModel()).thenReturn("gpt-3.5-turbo");
		when(chatGPTProperties.getMaxTokens()).thenReturn(100);
		when(chatGPTProperties.getTemperature()).thenReturn(0.7);
		when(chatGPTProperties.getTopP()).thenReturn(0.9);
		when(chatGPTProperties.getUrl()).thenReturn("https://api.openai.com/v1/completions");
	}

	@Test
	public void testSendMessage() {
		ChatResponse chatResponse = new ChatResponse();
		Choice choice = new Choice();
		choice.setText("Test response");
		chatResponse.setChoices(List.of(choice));

		when(chatGPTRestClient.postForEntity(
			any(String.class),
			any(HttpEntity.class),
			eq(ChatResponse.class)
		)).thenReturn(chatResponse);

		String response = chatGPTServiceImpl.sendMessage("Test message");
		assertEquals("Test response", response);
	}
}
