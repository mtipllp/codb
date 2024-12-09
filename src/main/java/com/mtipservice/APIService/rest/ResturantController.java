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
import com.mtipservice.APIService.entity.CreateResturantRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.service.ResturantService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class ResturantController {
	
	@Autowired
	ResturantService service;

	private static final Logger LOGGER = LoggerFactory.getLogger(ResturantController.class);

	@Operation(description = "Get Resturant")
	@GetMapping(path = "/getResturant/{resturantid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getResturant(@RequestHeader("sessionid") String sessionid, @PathVariable("resturantId") int resturantId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getResturant");
		LOGGER.info("Getting Resturant for Resturant Id " + resturantId);
		LOGGER.info("Getting Resturant IN"); 
		return service.getResturant(resturantId, new Response());
	}

	@Operation(description = "Get Resturants of a dish")
	@PostMapping(path = "/getResturants/{dishid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getResturantsFromDish(@RequestHeader("sessionid") String sessionid, @PathVariable("dishid") int dishid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getResturantsFromDish");
		LOGGER.info("Getting Resturants for Dish Id " + dishid);
		LOGGER.info("Getting Resturants for Dish Id IN"); 
		return service.getResturantsFromDish(dishid, new Response());
	}

	@Operation(description = "Get Resturants at location")
	@PostMapping(path = "/getResturants/{locationid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getResturantsAtLocation(@RequestHeader("sessionid") String sessionid, @PathVariable("location") String location) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getResturantsAtLocation");
		LOGGER.info("Getting Resturants at lcoation " + location);
		LOGGER.info("Getting Resturants at location IN"); 
		return service.getAllResturantsAtLocation(location, new Response());
	}

	@Operation(description = "Get All Resturants")
	@GetMapping(path = "/getAllResturants", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllDishes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllResturants");
		LOGGER.info("Getting All Resturants ");
		LOGGER.info("Getting All Resturants IN"); 
		return service.getAllResturants(new Response());
	}
	
	@Operation(description = "Create Resturant")
	@PostMapping(path = "/createResturant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createResturant(@RequestHeader("sessionid") String sessionid, @RequestBody CreateResturantRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createResturant");
		LOGGER.info("Creating Resturant for Resturant name "+request.getName());
		LOGGER.info("Create Resturant IN"); 
		return service.createResturant(request, new Response());
	}
	
	@Operation(description = "Update Resturant")
	@PostMapping(path = "/updateResturant/{resturantId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateResturant(@RequestHeader("sessionid") String sessionid, @RequestBody CreateResturantRequest request
			, @PathVariable("resturantId") int resturantId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "updateResturant");
		LOGGER.info("Updating Resturant for Resturant Id "+resturantId);
		LOGGER.info("Update Resturant IN"); 
		return service.updateResturant(resturantId, request, new Response());
	}
	
	@Operation(description = "Delete Resturant")
	@DeleteMapping(path = "/deleteResturant/{ResturantId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteResturant(@RequestHeader("sessionid") String sessionid, @PathVariable("resturantId") int resturantId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteResturant");
		LOGGER.info("Deleting Resturant for Resturant id "+resturantId);
		LOGGER.info("Delete Resturant IN"); 
		return service.deleteResturant(resturantId, new Response());
	}

}
