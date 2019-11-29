package com.siar.pets.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:http.properties")
@ConfigurationProperties
public class HttpProperties {

	private String httpUrlBase;
	
	private String petEverythingPet;
	private String petByStatus;
	
	
	
	/*****************************************/
	public void setHttpUrlBase(String httpUrlBase) {
		this.httpUrlBase = httpUrlBase;
	}
	public String getHttpUrlBase() {
		return httpUrlBase;
	}
	
	public void setPetEverythingPet(String petEverythingPet) {
		this.petEverythingPet = petEverythingPet;
	}
	public String getPetEverythingPet() {
		return petEverythingPet;
	}
	
	public void setPetByStatus(String petByStatus) {
		this.petByStatus = petByStatus;
	}
	public String getPetByStatus() {
		return petByStatus;
	}
}
