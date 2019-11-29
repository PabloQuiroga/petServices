package com.siar.pets.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.siar.pets.configs.HttpProperties;

public class PetRepository extends AbstractRepository{

	@Autowired
	HttpProperties properties;
	
	//TODO insert code here
	
	@Override
	protected String getHttpBaseUrl() {
		return this.properties.getHttpUrlBase();
	}

}
