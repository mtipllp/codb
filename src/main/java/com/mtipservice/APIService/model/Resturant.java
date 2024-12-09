package com.mtipservice.APIService.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the resturant database table.
 * 
 */
@Entity
@NamedQuery(name="Resturant.findAll", query="SELECT r FROM Resturant r")
public class Resturant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int docid;

	private String address;

	private String location;

	private String name;

	private String placeId;

	private String rating;

	private String state;

	private String telephone;

	public Resturant() {
	}

	public int getDocid() {
		return this.docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}