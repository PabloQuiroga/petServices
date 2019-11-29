package com.siar.pets.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractRepository {

	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", String.format("Bearer %s", ""));
		return headers;
	}

	
	public <T> T getForObject(String url, Class<T> cls) {
		HttpEntity<?> request = new HttpEntity<Object>(this.createHeaders());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, request, cls);

		return response.getBody();
	}

	public <T> T postForObject(String url, Object body, Class<T> cls) {
		HttpHeaders headers = this.createHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("accept", "application/json");
		HttpEntity<?> request = new HttpEntity<>(this.mapToJson(body), headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, request, cls);

		return response.getBody();
	}
	
	protected String mapToJson(Object obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(obj);
		} catch (Exception jsonEx) {
			throw new RuntimeException(jsonEx);
		}
	}
	
	protected abstract String getHttpBaseUrl(); 
}
