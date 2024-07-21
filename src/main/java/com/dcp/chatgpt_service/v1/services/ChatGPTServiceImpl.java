package com.dcp.chatgpt_service.v1.services;

import com.dcp.chatgpt_service.v1.config.ChatGPTProperties;
import com.dcp.chatgpt_service.v1.models.ChatRequest;
import com.dcp.chatgpt_service.v1.models.ChatResponse;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatMessage;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatRequest;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatResponse;
import com.dcp.chatgpt_service.v1.models.image.ImageFormat;
import com.dcp.chatgpt_service.v1.models.image.ImageRequest;
import com.dcp.chatgpt_service.v1.models.image.ImageResponse;
import com.dcp.chatgpt_service.v1.models.image.ImageSize;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ChatGPTServiceImpl implements ChatGPTService {

	private final ChatGPTProperties chatgptProperties;
	private final ChatGPTRestClient chatGPTRestClient;
	private final String authorization;

	public ChatGPTServiceImpl(@Qualifier("chatGPTProperties") ChatGPTProperties chatgptProperties, ChatGPTRestClient chatGPTRestClient) {
		this.chatgptProperties = chatgptProperties;
		this.chatGPTRestClient = chatGPTRestClient;
		this.authorization = "Bearer " + chatgptProperties.getApiKey();
	}

	@Override
	public String sendMessage(String message) {
		ChatRequest chatRequest = new ChatRequest(chatgptProperties.getModel(), message, chatgptProperties.getMaxTokens(), chatgptProperties.getTemperature(), chatgptProperties.getTopP());
		ChatResponse chatResponse = this.sendChatRequest(chatRequest);

		return chatResponse.getChoices().getFirst().getText();
	}

	@Override
	public ChatResponse sendChatRequest(ChatRequest chatRequest) {
		return this.getResponse(chatRequest, ChatResponse.class, chatgptProperties.getUrl());
	}

	@Override
	public String multiChat(List<MultiChatMessage> messages) {
		MultiChatRequest multiChatRequest = new MultiChatRequest(chatgptProperties.getMulti().getModel(), messages, chatgptProperties.getMulti().getMaxTokens(), chatgptProperties.getMulti().getTemperature(), chatgptProperties.getMulti().getTopP());
		MultiChatResponse multiChatResponse = this.multiChatRequest(multiChatRequest);

		return multiChatResponse.getChoices().getFirst().getMessage().getContent();
	}

	@Override
	public MultiChatResponse multiChatRequest(MultiChatRequest multiChatRequest) {
		return this.getResponse(multiChatRequest, MultiChatResponse.class, chatgptProperties.getMulti().getUrl());
	}

	@Override
	public String generateImage(String prompt) {
		ImageRequest imageRequest = new ImageRequest(prompt, null, null, null, null);
		ImageResponse imageResponse = this.generateImageResponse(imageRequest);

		return imageResponse.getData().getFirst().getUrl();
	}

	@Override
	public List<String> generateImage(String prompt, Integer n, ImageSize size, ImageFormat format) {
		ImageRequest imageRequest = new ImageRequest(prompt, n, size.getSize(), format.getFormat(), null);
		ImageResponse imageResponse = this.generateImageResponse(imageRequest);

		List<String> urls = new ArrayList<>();

		imageResponse.getData().forEach(imageData -> {
			if (format.equals(ImageFormat.URL)) {
				urls.add(imageData.getUrl());
			} else {
				urls.add(imageData.getB64Json());
			}
		});

		return urls;
	}

	@Override
	public ImageResponse generateImageResponse(ImageRequest imageRequest) {
		return this.getResponse(imageRequest, ImageResponse.class, chatgptProperties.getImage().getUrl());
	}

	private <T> T getResponse(Object request, Class<T> responseType, String url) {
		HttpEntity<?> httpEntity = new HttpEntity<>(request, chatGPTRestClient.createHeaders(authorization));

		return chatGPTRestClient.postForEntity(url, httpEntity, responseType);
	}
}
