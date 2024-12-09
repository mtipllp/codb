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
import com.mtipservice.APIService.entity.CreateDishRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.service.DishService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class DishController {
	
	@Autowired
	DishService service;


	private static final Logger LOGGER = LoggerFactory.getLogger(DishController.class);

	@Operation(description = "Get Dish")
	@GetMapping(path = "/getDish/{dishid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getDish(@RequestHeader("sessionid") String sessionid, @PathVariable("dishId") int dishId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getDish");
		LOGGER.info("Getting Dish for Dish Id " + dishId);
		LOGGER.info("Getting Dish IN"); 
		return service.getDish(dishId, new Response());
	}
	
	@Operation(description = "Get Dish By Dish Name")
	@GetMapping(path = "/getDishByDishName/{dishname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getDishByDishName(@RequestHeader("sessionid") String sessionid, @PathVariable("dishname") String dishname) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getDishByDishName");
		LOGGER.info("Getting Dish for Dish Name " + dishname);
		LOGGER.info("Getting Dish IN"); 
		return service.getDishByDishName(dishname, new Response());
	}
	
	@Operation(description = "Get All Dishes")
	@GetMapping(path = "/getAllDishes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllDishes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllDishes");
		LOGGER.info("Getting All Dishes ");
		LOGGER.info("Getting All Dishes IN"); 
		return service.getAllDishes(new Response());
	}
	
	@Operation(description = "Create Dish")
	@PostMapping(path = "/createDish", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createDish(@RequestHeader("sessionid") String sessionid, @RequestBody CreateDishRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createDish");
		LOGGER.info("Creating Dish for dish name "+request.getName());
		LOGGER.info("Create Dish IN"); 
		return service.createDish(request, new Response());
	}
	
	@Operation(description = "Update Dish")
	@PostMapping(path = "/updateDish/{dishId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateDish(@RequestHeader("sessionid") String sessionid, @RequestBody CreateDishRequest request
			, @PathVariable("dishId") int dishId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "updateDish");
		LOGGER.info("Update Dish for dish Id "+dishId);
		LOGGER.info("Update Dish IN"); 
		return service.updateDish(dishId, request, new Response());
	}
	
	@Operation(description = "Delete Dish")
	@DeleteMapping(path = "/deleteDish", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteDish(@RequestHeader("sessionid") String sessionid, @PathVariable("dishId") int dishId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteDish");
		LOGGER.info("Deleting Dish for dish id "+dishId);
		LOGGER.info("Delete Dish IN"); 
		return service.deleteDish(dishId, new Response());
	}

}
