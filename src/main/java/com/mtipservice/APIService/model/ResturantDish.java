package com.mtipservice.APIService.model;

import java.io.Serializable;
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

}