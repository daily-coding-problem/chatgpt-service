package com.dcp.chatgpt_service.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;

@Getter
@Configuration
@ConfigurationProperties(prefix = "properties")
@Validated
public class Properties {
	private final Cors cors = new Cors();

	@Setter
	public static class Cors {
		private String allowedOrigins = "*";

		public List<String> getAllowedOrigins() {
			if (allowedOrigins == null || allowedOrigins.isBlank()) {
				return List.of("*");
			}
			return Arrays.asList(allowedOrigins.split(","));
		}
	}
}
