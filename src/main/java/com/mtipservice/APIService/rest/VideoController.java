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
import com.mtipservice.APIService.entity.CreateVideoRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.service.VideoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class VideoController {
	@Autowired
	VideoService service;


	private static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);

	@Operation(description = "Get Video")
	@GetMapping(path = "/getVideo/{language}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getVideo(@RequestHeader("sessionid") String sessionid, @PathVariable("language") String language, @PathVariable("type") String type) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getVideo");
		LOGGER.info("Getting Video for Video language " + language + " and type " + type);
		LOGGER.info("Getting Video IN"); 
		return service.getVideo(language, type, new Response());
	}
	
	
	@Operation(description = "Get All Videoes")
	@GetMapping(path = "/getAllVideos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllVideoes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllVideoes");
		LOGGER.info("Getting All Videoes ");
		LOGGER.info("Getting All Videoes IN"); 
		return service.getAllVideos(new Response());
	}
	
	@Operation(description = "Create Video")
	@PostMapping(path = "/createVideo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createVideo(@RequestHeader("sessionid") String sessionid, @RequestBody CreateVideoRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createVideo");
		LOGGER.info("Creating Video for Video language "+request.getLanguage());
		LOGGER.info("Create Video IN"); 
		return service.createVideo(request, new Response());
	}
	
	@Operation(description = "Update Video")
	@PostMapping(path = "/updateVideo/{videoId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateVideo(@RequestHeader("sessionid") String sessionid, @RequestBody CreateVideoRequest request
			, @PathVariable("language") String language, @PathVariable("type") String type) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "updateVideo");
		LOGGER.info("Update Video for language "+language + " and type "+ type);
		LOGGER.info("Update Video IN"); 
		return service.updateVideo(language, type, request, new Response());
	}
	
	@Operation(description = "Delete Video")
	@DeleteMapping(path = "/deleteVideo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteVideo(@RequestHeader("sessionid") String sessionid, @PathVariable("language") String language, @PathVariable("type") String type) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteVideo");
		LOGGER.info("Deleting Video for language "+language + " and type "+ type);
		LOGGER.info("Delete Video IN"); 
		return service.deleteVideo(language, type, new Response());
	}

}
