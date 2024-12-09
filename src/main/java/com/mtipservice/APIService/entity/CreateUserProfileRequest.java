package com.mtipservice.APIService.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CreateUserProfileRequest {

	private String clientId;

	private String clientSecret;

	private String clientType;

	private String deviceId;

	private int docidStartup;

	private int docidVideo;

	private String email;

	private byte isStartupVideoPlayed;

	private String language;

	private String nickName;

	private String username;

	public CreateUserProfileRequest() {
		super();
	}

	public CreateUserProfileRequest(String clientId, String clientSecret, String clientType, String deviceId,
			int docidStartup, int docidVideo, String email, byte isStartupVideoPlayed, String language, String nickName,
			String username) {
		super();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.clientType = clientType;
		this.deviceId = deviceId;
		this.docidStartup = docidStartup;
		this.docidVideo = docidVideo;
		this.email = email;
		this.isStartupVideoPlayed = isStartupVideoPlayed;
		this.language = language;
		this.nickName = nickName;
		this.username = username;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public int getDocidStartup() {
		return docidStartup;
	}

	public void setDocidStartup(int docidStartup) {
		this.docidStartup = docidStartup;
	}

	public int getDocidVideo() {
		return docidVideo;
	}

	public void setDocidVideo(int docidVideo) {
		this.docidVideo = docidVideo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getIsStartupVideoPlayed() {
		return isStartupVideoPlayed;
	}

	public void setIsStartupVideoPlayed(byte isStartupVideoPlayed) {
		this.isStartupVideoPlayed = isStartupVideoPlayed;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
