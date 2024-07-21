package com.dcp.chatgpt_service;

import static org.assertj.core.api.Assertions.assertThat;

import com.dcp.chatgpt_service.v1.controllers.ChatGPTControllerImpl;
import com.dcp.chatgpt_service.v1.services.ChatGPTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatGPTServiceApplicationTests {

	@Autowired
	private ChatGPTService chatGPTService;

	@Autowired
	private ChatGPTControllerImpl chatGPTController;

	@Test
	void contextLoads() {
		// This test ensures that the application context loads successfully.
	}

	@Test
	void testChatGPTServiceBean() {
		// Ensure that the ChatGPTService bean is loaded
		assertThat(chatGPTService).isNotNull();
	}

	@Test
	void testChatGPTControllerBean() {
		// Ensure that the ChatGPTControllerImpl bean is loaded
		assertThat(chatGPTController).isNotNull();
	}
}
