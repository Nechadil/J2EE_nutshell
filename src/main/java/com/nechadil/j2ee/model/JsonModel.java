package com.nechadil.j2ee.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonModel {
	private String id;
	private String description;
	
	/**
	 * !!! The default constructor is needed for ORM to instantiate the object and then load the object from request!!!
	 * Impacted method is {@link com.nechadil.j2ee.rest.apis.RestApplication#postJson(JsonModel)}
	 */
	public JsonModel() {
		
	}
	
	public JsonModel(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String toString(){
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return "not parseable";
		}
	}
}
