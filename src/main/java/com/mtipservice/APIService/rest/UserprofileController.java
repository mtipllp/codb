package com.mtipservice.APIService.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mtipservice.APIService.Constants;
import com.mtipservice.APIService.entity.CreateSessiondataRequest;
import com.mtipservice.APIService.entity.CreateUserProfileRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.service.UserProfileService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class UserprofileController {
	
	@Autowired
	UserProfileService service;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserprofileController.class);

	@Operation(description = "Get Userprofile")
	@GetMapping(path = "/getUserprofile/{userprofileid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getUserprofile(@RequestHeader("sessionid") String sessionid, @PathVariable("userprofileId") int userprofileId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofile");
		LOGGER.info("Getting Userprofile for Userprofile Id " + userprofileId);
		LOGGER.info("Getting Userprofile IN"); 
		return service.getUserprofile(userprofileId, new Response());
	}

	@Operation(description = "Get Userprofile from username")
	@PostMapping(path = "/getUserprofileUserName/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getUserprofilesFromUserName(@RequestHeader("sessionid") String sessionid, @PathVariable("username") String username) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromUserName");
		LOGGER.info("Getting Userprofiles for UserName " + username);
		LOGGER.info("Getting Userprofiles for UserName IN"); 
		return service.getUserProfileFromUsername(username, new Response());
	}

	@Operation(description = "Get Userprofile from clientid")
	@PostMapping(path = "/getUserprofileClientId/{clientid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getUserprofilesFromClientId(@RequestHeader("sessionid") String sessionid, @PathVariable("clientid") String clientid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromClientId");
		LOGGER.info("Getting Userprofiles for ClientId " + clientid);
		LOGGER.info("Getting Userprofiles for Client Id IN"); 
		return service.getUserProfileFromClientId(clientid, new Response());
	}

	@Operation(description = "Get Userprofile from deviceid")
	@PostMapping(path = "/getUserprofileDeviceId/{deviceid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getUserprofilesFromDeviceId(@RequestHeader("sessionid") String sessionid, @PathVariable("deviceid") String clientid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromClientId");
		LOGGER.info("Getting Userprofiles for ClientId " + clientid);
		LOGGER.info("Getting Userprofiles for Client Id IN"); 
		return service.getUserProfileFromClientId(clientid, new Response());
	}

	@Operation(description = "Get All Userprofiles")
	@GetMapping(path = "/getAllUserprofiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllDishes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllUserprofiles");
		LOGGER.info("Getting All Userprofiles ");
		LOGGER.info("Getting All Userprofiles IN"); 
		return service.getAllUserprofiles(new Response());
	}
	
	
	@Operation(description = "Create Userprofile")
	@PostMapping(path = "/createUserprofile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createUserprofile(@RequestHeader("sessionid") String sessionid, @RequestBody CreateUserProfileRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createUserprofile");
		LOGGER.info("Create Userprofile for Userprofile device id "+request.getDeviceId());
		LOGGER.info("Create Userprofile IN"); 
		return service.createUserprofile(request, new Response());
	}
	
	@Operation(description = "Update Userprofile")
	@PostMapping(path = "/updateUserprofile/{userprofileId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateUserprofile(@RequestHeader("sessionid") String sessionid, @RequestBody CreateUserProfileRequest request
			, @PathVariable("userprofileId") int userprofileId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "updateUserprofile");
		LOGGER.info("Updating Userprofile for Userprofile Id "+userprofileId);
		LOGGER.info("Update Userprofile IN"); 
		return service.updateUserprofile(userprofileId, request, new Response());
	}
	
	@Operation(description = "Delete Userprofile")
	@DeleteMapping(path = "/deleteUserprofile/{userprofileId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteUserprofile(@RequestHeader("sessionid") String sessionid, @PathVariable("userprofileId") int userprofileId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteUserprofile");
		LOGGER.info("Deleting Userprofile for Userprofile id "+userprofileId);
		LOGGER.info("Delete Userprofile IN"); 
		return service.deleteUserprofile(userprofileId, new Response());
	}

	@Operation(description = "Add or Update Session of User")
	@PostMapping(path = "/addOrUpdateSession", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> addOrUpdateSession(@RequestHeader("sessionid") String sessionid, @RequestBody CreateSessiondataRequest request) {
		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "addOrUpdateSession");
		LOGGER.info("Add or update session information for user id "+request.getUserprofileid());
		LOGGER.info("Add or update session information for user id IN"); 
		return service.createOrUpdateSessionInfo(request, new Response());
	}
	

	@Operation(description = "Get All Session Data from userid")
	@PostMapping(path = "/getAllSessionFromUserId/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllSessionFromUserId(@RequestHeader("sessionid") String sessionid, @PathVariable("userid") int userid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromUserName");
		LOGGER.info("Getting User Session Data for UserId " + userid);
		LOGGER.info("Getting User Session Data for UserId IN"); 
		return service.getAllSessionsFromUserId(userid, new Response());
	}
	
	@Operation(description = "Get Client Credentials")
	@GetMapping(path = "/getClientcredentials/{userprofileid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getClientCredentials(@RequestHeader("sessionid") String sessionid, @PathVariable("userprofileid") int userprofileid) {
		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getClientCredentials");
		LOGGER.info("Getting Client Credentials for userprofileid " + userprofileid);
		LOGGER.info("Getting Client Credentials for userprofileid IN"); 
		return service.getClientCredentials(userprofileid, new Response());
		
	}
}
