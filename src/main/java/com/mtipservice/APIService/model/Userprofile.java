package com.mtipservice.APIService.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the userprofile database table.
 * 
 */
@Entity
@NamedQuery(name="Userprofile.findAll", query="SELECT u FROM Userprofile u")
public class Userprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int docid;

	private String clientId;

	private String clientSecret;

	private String clientType;

	private String deviceId;

	@Column(name="docid_startup")
	private int docidStartup;

	@Column(name="docid_video")
	private int docidVideo;

	private String email;

	private byte isStartupVideoPlayed;

	private String language;

	private String nickName;

	private String username;

	public Userprofile() {
	}

	public int getDocid() {
		return this.docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return this.clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientType() {
		return this.clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public int getDocidStartup() {
		return this.docidStartup;
	}

	public void setDocidStartup(int docidStartup) {
		this.docidStartup = docidStartup;
	}

	public int getDocidVideo() {
		return this.docidVideo;
	}

	public void setDocidVideo(int docidVideo) {
		this.docidVideo = docidVideo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsStartupVideoPlayed() {
		return this.isStartupVideoPlayed;
	}

	public void setIsStartupVideoPlayed(byte isStartupVideoPlayed) {
		this.isStartupVideoPlayed = isStartupVideoPlayed;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}