package com.dcp.chatgpt_service.v1.services;

import com.dcp.chatgpt_service.v1.models.ChatRequest;
import com.dcp.chatgpt_service.v1.models.ChatResponse;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatMessage;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatRequest;
import com.dcp.chatgpt_service.v1.models.chat.MultiChatResponse;
import com.dcp.chatgpt_service.v1.models.image.ImageFormat;
import com.dcp.chatgpt_service.v1.models.image.ImageRequest;
import com.dcp.chatgpt_service.v1.models.image.ImageResponse;
import com.dcp.chatgpt_service.v1.models.image.ImageSize;

import java.util.List;

public interface ChatGPTService {
	String sendMessage(String message);

	ChatResponse sendChatRequest(ChatRequest request);

	String multiChat(List<MultiChatMessage> messages);

	MultiChatResponse multiChatRequest(MultiChatRequest multiChatRequest);

	/**
	 * @param prompt A text description of the desired image(s). The maximum length is 1000 characters.
	 * @return generated image url
	 */
	String generateImage(String prompt);

	/**
	 * @param prompt A text description of the desired image(s). The maximum length is 1000 characters.
	 * @param n      The number of images to generate. Must be between 1 and 10.
	 * @param size   The size of the generated images. Must be one of ImageFormat.SMALL("256x256"), ImageFormat.MEDIUM("512x512"), ImageFormat.LARGE("1024x1024").
	 * @param format The format in which the generated images are returned. Must be one of ImageFormat.URL("url"), ImageFormat.BASE64("b64_json").
	 * @return image url/base64 list
	 */
	List<String> generateImage(String prompt, Integer n, ImageSize size, ImageFormat format);

	ImageResponse generateImageResponse(ImageRequest imageRequest);
}
