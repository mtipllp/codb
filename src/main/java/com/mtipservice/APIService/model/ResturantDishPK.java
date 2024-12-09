package com.mtipservice.APIService.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ResturantDishPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int dishId;

	private int resId;

	public int getDishId() {
		return this.dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getResId() {
		return this.resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

}
