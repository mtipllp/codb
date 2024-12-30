package com.mtipservice.APIService.model;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.persistence.*;


/**
 * The persistent class for the resturant_dish database table.
 * 
 */
@Entity
@Table(name="resturant_dish")
@NamedQuery(name="ResturantDish.findAll", query="SELECT r FROM ResturantDish r")
public class ResturantDish implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResturantDishPK id;

	public ResturantDish() {
	}

	public ResturantDishPK getId() {
		return this.id;
	}

	public void setId(ResturantDishPK id) {
		this.id = id;
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