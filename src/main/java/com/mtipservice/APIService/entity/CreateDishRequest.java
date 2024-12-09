package com.mtipservice.APIService.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CreateDishRequest {

	private String image;

	private String ingredients;

	private String name;

	private String preperationTime;

	public CreateDishRequest() {
		super();
	}

	public CreateDishRequest(String image, String ingredients, String name, String preperationTime) {
		super();
		this.image = image;
		this.ingredients = ingredients;
		this.name = name;
		this.preperationTime = preperationTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreperationTime() {
		return preperationTime;
	}

	public void setPreperationTime(String preperationTime) {
		this.preperationTime = preperationTime;
	}
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

}
