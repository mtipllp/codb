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
import com.mtipservice.APIService.entity.CreateIngredientRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.service.IngredientService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class IngredientController {
	
	@Autowired
	IngredientService service;

	private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

	@Operation(description = "Get Ingredient")
	@GetMapping(path = "/getIngredient/{ingredientid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getIngredient(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getIngredient");
		LOGGER.info("Getting Ingredient for Ingredient Id " + ingredientId);
		LOGGER.info("Getting Ingredient IN"); 
		return service.getIngredient(ingredientId, new Response());
	}

	@Operation(description = "Get Ingredients of a dish")
	@PostMapping(path = "/getIngredients/{ingredientIds}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getIngredients(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientIds") List<Integer> ingredientIds) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getIngredients");
		LOGGER.info("Getting Ingredients for Ingredient Ids " + ingredientIds);
		LOGGER.info("Getting Ingredients IN"); 
		return service.getIngredients(new ArrayList<Integer>(ingredientIds), new Response());
	}
	
	@Operation(description = "Get All Ingredients")
	@GetMapping(path = "/getAllIngredients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllDishes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllIngredients");
		LOGGER.info("Getting All Ingredients ");
		LOGGER.info("Getting All Ingredients IN"); 
		return service.getAllIngredients(new Response());
	}
	
	@Operation(description = "Create Ingredient")
	@PostMapping(path = "/createIngredient", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createIngredient(@RequestHeader("sessionid") String sessionid, @RequestBody CreateIngredientRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createIngredient");
		LOGGER.info("Creating Ingredient for Ingredient name "+request.getName());
		LOGGER.info("Create Ingredient IN"); 
		return service.createIngredient(request, new Response());
	}
	
	@Operation(description = "Update Ingredient")
	@PostMapping(path = "/updateIngredient/{ingredientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateIngredient(@RequestHeader("sessionid") String sessionid, @RequestBody CreateIngredientRequest request
			, @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "updateIngredient");
		LOGGER.info("Updating Ingredient for Ingredient Id "+ingredientId);
		LOGGER.info("Update Ingredient IN"); 
		return service.updateIngredient(ingredientId, request, new Response());
	}
	
	@Operation(description = "Delete Ingredient")
	@DeleteMapping(path = "/deleteIngredient/{ingredientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteIngredient(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteIngredient");
		LOGGER.info("Deleting Ingredient for Ingredient id "+ingredientId);
		LOGGER.info("Delete Ingredient IN"); 
		return service.deleteIngredient(ingredientId, new Response());
	}

	@Operation(description = "Insert or Get Ingredient Supplier")
	@PostMapping(path = "/insertOrGetIngredient/{ingredientId}/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> insertOrGetIngredient(@RequestHeader("sessionid") String sessionid
			, @PathVariable("supplierId") int supplierId , @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "insertOrGetIngredient");
		LOGGER.info("Insert or Get Ingredient Supplier for Ingredient Id "+ingredientId);
		LOGGER.info("Update Ingredient IN"); 
		return service.ingredientSupplierAssociation(ingredientId, supplierId, new Response());
	}

	@Operation(description = "Get Suppliers of Ingredient")
	@GetMapping(path = "/getSuppliersOfIngredient/{ingredientid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getSupplierOfIngredient(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getSupplierOfIngredient");
		LOGGER.info("Getting Supplier of Ingredient for Ingredient Id " + ingredientId);
		LOGGER.info("Getting Supplier of Ingredient IN"); 
		return service.getSuppliersOfIngredients(ingredientId, new Response());
	}

	@Operation(description = "Get Ingredient")
	@GetMapping(path = "/getIngredientsOfSupplier/{supplierid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getIngredientsOfSupplier(@RequestHeader("sessionid") String sessionid, @PathVariable("supplierid") int supplierid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getIngredientsOfSupplier");
		LOGGER.info("Getting Ingredients of Supplier for Supplier Id " + supplierid);
		LOGGER.info("Getting Ingredients of Supplier IN"); 
		return service.getIngredientsOfSupplier(supplierid, new Response());
	}
	
}
