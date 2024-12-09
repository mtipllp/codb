package com.mtipservice.APIService.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the startup_images database table.
 * 
 */
@Entity
@Table(name="startup_images")
@NamedQuery(name="StartupImage.findAll", query="SELECT s FROM StartupImage s")
public class StartupImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int docid;

	private String language;

	private String link;

	private String type;

	public StartupImage() {
	}

	public int getDocid() {
		return this.docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}