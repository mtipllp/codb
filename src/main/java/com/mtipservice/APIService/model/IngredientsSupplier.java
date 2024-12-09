package com.mtipservice.APIService.model;

import java.io.Serializable;
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

}