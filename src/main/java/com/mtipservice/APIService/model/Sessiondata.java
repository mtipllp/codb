package com.mtipservice.APIService.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


/**
 * The persistent class for the sessiondata database table.
 * 
 */
@Entity
@NamedQuery(name="Sessiondata.findAll", query="SELECT s FROM Sessiondata s")
public class Sessiondata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String session;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enddate;

	private String endLevel;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;

	private String startLevel;
	
	private int userprofileid;

	public Sessiondata() {
	}

	public int getUserprofileid() {
		return userprofileid;
	}

	public void setUserprofileid(int userprofileid) {
		this.userprofileid = userprofileid;
	}

	public String getSession() {
		return this.session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getEndLevel() {
		return this.endLevel;
	}

	public void setEndLevel(String endLevel) {
		this.endLevel = endLevel;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getStartLevel() {
		return this.startLevel;
	}

	public void setStartLevel(String startLevel) {
		this.startLevel = startLevel;
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