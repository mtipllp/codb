package com.mtipservice.APIService.model;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.persistence.*;


/**
 * The persistent class for the ingredients_supplier database table.
 * 
 */
@Entity
@Table(name="ingredients_supplier")
@NamedQuery(name="IngredientsSupplier.findAll", query="SELECT i FROM IngredientsSupplier i")
public class IngredientsSupplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IngredientsSupplierPK id;

	public IngredientsSupplier() {
	}

	public IngredientsSupplierPK getId() {
		return this.id;
	}

	public void setId(IngredientsSupplierPK id) {
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