package com.mtipservice.APIService.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the videos database table.
 * 
 */
@Embeddable
public class VideoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String language;

	private String type;

	public VideoPK() {
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VideoPK)) {
			return false;
		}
		VideoPK castOther = (VideoPK)other;
		return 
			this.language.equals(castOther.language)
			&& this.type.equals(castOther.type);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.language.hashCode();
		hash = hash * prime + this.type.hashCode();
		
		return hash;
	}
}