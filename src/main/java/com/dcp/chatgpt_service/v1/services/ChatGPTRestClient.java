package com.dcp.chatgpt_service.v1.services;

import com.dcp.chatgpt_service.v1.exceptions.ChatGPTException;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChatGPTRestClient {
	private final RestTemplate restTemplate;

	public ChatGPTRestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public <T> T postForEntity(String url, HttpEntity<?> httpEntity, Class<T> responseType) {
		ResponseEntity<T> responseEntity = restTemplate.postForEntity(url, httpEntity, responseType);

		if (responseEntity.getStatusCode() != HttpStatus.OK) {
			throw new ChatGPTException("Error response status: " + responseEntity.getStatusCode());
		}

		return responseEntity.getBody();
	}

	public HttpHeaders createHeaders(String authorization) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authorization);

		return headers;
	}
}

