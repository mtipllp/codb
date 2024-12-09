package com.mtipservice.APIService.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mtipservice.APIService.entity.ClientCredentials;
import com.mtipservice.APIService.entity.CreateSessiondataRequest;
import com.mtipservice.APIService.entity.CreateUserProfileRequest;
import com.mtipservice.APIService.entity.Errors;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.Sessiondata;
import com.mtipservice.APIService.model.Userprofile;
import com.mtipservice.APIService.repository.SessiondataRepository;
import com.mtipservice.APIService.repository.UserprofileRepository;

@Service
public class UserProfileService {
	@Autowired
	UserprofileRepository userprofileRepository;
	
	@Autowired
	SessiondataRepository sessiondataRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileService.class);
	
	public ResponseEntity<Response> getUserprofile(int UserprofileDocId, Response res) {
		try {
			Userprofile userpr = userprofileRepository.getUserprofile(UserprofileDocId);
			res.setResponse(userpr);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getAllUserprofiles(Response res) {
		try {
			List<Userprofile> userprofiles = userprofileRepository.findAll();
			res.setResponse(userprofiles);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofiles has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> createUserprofile(CreateUserProfileRequest request, Response res) {
		try {
			Userprofile userprofile = new Userprofile();
			BeanUtils.copyProperties(request, userprofile);
			userprofileRepository.save(userprofile);
			String resp = "Create Userprofile ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Create Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}


	public ResponseEntity<Response> updateUserprofile(int UserprofileId, CreateUserProfileRequest request, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofile(UserprofileId);
			BeanUtils.copyProperties(request, userprofile);
			userprofileRepository.save(userprofile);
			String resp = "Update Userprofile ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Update Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> deleteUserprofile(int UserprofileId, Response res) {
		try {
			userprofileRepository.deleteUserprofile(UserprofileId);
			String resp = "Delete Userprofile ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Delete Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> getUserProfileFromUsername(String username, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofileFromUsername(username);
			res.setResponse(userprofile);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> getUserProfileFromClientId(String clientid, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofileFromClientId(clientid);
			res.setResponse(userprofile);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> getUserProfileFromDeviceId(String deviceid, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofileFromDeviceId(deviceid);
			res.setResponse(userprofile);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getClientCredentials(int userProfileId, Response res) {
		try {
			ClientCredentials clientCredentials = userprofileRepository.getClientCredentials(userProfileId);
			res.setResponse(clientCredentials);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Getting Client Credentials has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Getting Client Credentials has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
		
	}
	
	public ResponseEntity<Response> createOrUpdateSessionInfo(CreateSessiondataRequest request, Response res) {
		try {
			Sessiondata sd = sessiondataRepository.getSessiondata(request.getSession());
			if(sd == null) {
				sd = new Sessiondata();
			}
			BeanUtils.copyProperties(request, sd);
			sessiondataRepository.save(sd);
			res.setResponse(sd);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			LOGGER.error("Create Or Update Session Info has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Or Update Session Info has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getAllSessionsFromUserId(int userprofileId, Response res) {
		try {
			ArrayList<Sessiondata> sdList = sessiondataRepository.getSessiondataFromUserprofileid(userprofileId);
			res.setResponse(sdList);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			LOGGER.error("Get All Session Info from User Profile Id has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Get All Session Info from User Profile Id has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
		
	}
}
