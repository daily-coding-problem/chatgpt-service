package com.dcp.chatgpt_service.v1.config;

import com.dcp.chatgpt_service.v1.services.ChatGPTRestClient;
import com.dcp.chatgpt_service.v1.services.ChatGPTService;
import com.dcp.chatgpt_service.v1.services.ChatGPTServiceImpl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ChatGPTAutoConfig {
	private final ChatGPTRestClient chatGPTRestClient;
	private final ChatGPTProperties chatgptProperties;

	@Autowired
	public ChatGPTAutoConfig(ChatGPTRestClient chatGPTRestClient, @Qualifier("chatGPTProperties") ChatGPTProperties chatgptProperties) {
		this.chatGPTRestClient = chatGPTRestClient;
		this.chatgptProperties = chatgptProperties;

		log.debug("chatgpt-springboot-starter loaded.");
	}

	@Bean
	@ConditionalOnMissingBean(ChatGPTService.class)
	public ChatGPTService chatgptService() {
		return new ChatGPTServiceImpl(chatgptProperties, chatGPTRestClient);
	}
}
