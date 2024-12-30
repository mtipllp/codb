package com.mtipservice.APIService.model;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.persistence.*;


/**
 * The persistent class for the videos database table.
 * 
 */
@Entity
@Table(name="videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VideoPK id;

	private String audioLink;

	private String comments;

	private int dishId;

	private String link;

	public Video() {
	}

	public VideoPK getId() {
		return this.id;
	}

	public void setId(VideoPK id) {
		this.id = id;
	}

	public String getAudioLink() {
		return this.audioLink;
	}

	public void setAudioLink(String audioLink) {
		this.audioLink = audioLink;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getDishId() {
		return this.dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
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