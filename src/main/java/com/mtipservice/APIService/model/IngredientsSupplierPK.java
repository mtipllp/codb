package com.mtipservice.APIService.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class IngredientsSupplierPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int ingId;

	private int suppId;

	public int getIngId() {
		return this.ingId;
	}

	public void setIngId(int ingId) {
		this.ingId = ingId;
	}

	public int getSuppId() {
		return this.suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

}