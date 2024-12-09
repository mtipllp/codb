package com.mtipservice.APIService.rest;

import java.util.ArrayList;
import java.util.List;

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
import com.mtipservice.APIService.entity.CreateStartupImageRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.service.StartupImageService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class StartupImageController {
	
	@Autowired
	StartupImageService service;

	private static final Logger LOGGER = LoggerFactory.getLogger(StartupImageController.class);

	@Operation(description = "Get StartupImage")
	@GetMapping(path = "/getStartupImage/{startupImageid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getStartupImage(@RequestHeader("sessionid") String sessionid, @PathVariable("startupImageId") int startupImageId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getStartupImage");
		LOGGER.info("Getting StartupImage for startupImage Id " + startupImageId);
		LOGGER.info("Getting StartupImage IN"); 
		return service.getStartupImage(startupImageId, new Response());
	}

	@Operation(description = "Get StartupImage")
	@GetMapping(path = "/getStartupImageByLanguage/{language}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getStartupImageByLanguage(@RequestHeader("sessionid") String sessionid, @PathVariable("language") String language) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getStartupImage");
		LOGGER.info("Getting StartupImage for language " + language);
		LOGGER.info("Getting StartupImage IN"); 
		return service.getStartupImageByLanguage(language, new Response());
	}
	
	@Operation(description = "Get All Startup Images")
	@GetMapping(path = "/getAllStartup Images", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllDishes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllStartupImages");
		LOGGER.info("Getting All StartupImages ");
		LOGGER.info("Getting All StartupImages IN"); 
		return service.getAllStartupImages(new Response());
	}
	
	@Operation(description = "Create StartupImage")
	@PostMapping(path = "/createStartupImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createStartupImage(@RequestHeader("sessionid") String sessionid, @RequestBody CreateStartupImageRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createStartupImage");
		LOGGER.info("Creating StartupImage for StartupImage "+request.toString());
		LOGGER.info("Create StartupImage IN"); 
		return service.createStartupImages(request, new Response());
	}
	
	@Operation(description = "Update StartupImage")
	@PostMapping(path = "/updateStartupImage/{startupImageId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateStartupImage(@RequestHeader("sessionid") String sessionid, @RequestBody CreateStartupImageRequest request
			, @PathVariable("startupImageId") int startupImageId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "updateStartupImage");
		LOGGER.info("Updating StartupImage for StartupImage Id "+startupImageId);
		LOGGER.info("Update StartupImage IN"); 
		return service.updateStartupImage(startupImageId, request, new Response());
	}
	
	@Operation(description = "Delete StartupImage")
	@DeleteMapping(path = "/deleteStartupImage/{startupImageId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteStartupImage(@RequestHeader("sessionid") String sessionid, @PathVariable("startupImageId") int startupImageId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteStartupImage");
		LOGGER.info("Deleting StartupImage for StartupImage id "+startupImageId);
		LOGGER.info("Delete StartupImage IN"); 
		return service.deleteStartupImage(startupImageId, new Response());
	}
}
