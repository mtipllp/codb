package com.mtipservice.APIService.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CreateIngredientRequest {

	private String image;

	private String name;

	private int preference;

	private String price;

	private String qty;

	private String qtyUnit;

	private String sku;

	private int taxid;

	private String type;

	public CreateIngredientRequest() {
		super();
	}

	public CreateIngredientRequest(String image, String name, int preference, String price, String qty, String qtyUnit,
			String sku, int taxid, String type) {
		super();
		this.image = image;
		this.name = name;
		this.preference = preference;
		this.price = price;
		this.qty = qty;
		this.qtyUnit = qtyUnit;
		this.sku = sku;
		this.taxid = taxid;
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPreference() {
		return preference;
	}

	public void setPreference(int preference) {
		this.preference = preference;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getQtyUnit() {
		return qtyUnit;
	}

	public void setQtyUnit(String qtyUnit) {
		this.qtyUnit = qtyUnit;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getTaxid() {
		return taxid;
	}

	public void setTaxid(int taxid) {
		this.taxid = taxid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
