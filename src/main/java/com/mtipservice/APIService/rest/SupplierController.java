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
import com.mtipservice.APIService.entity.CreateSupplierRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.service.SupplierService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class SupplierController {
	
	@Autowired
	SupplierService service;

	private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);

	@Operation(description = "Get Supplier")
	@GetMapping(path = "/getSupplier/{supplierid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getSupplier(@RequestHeader("sessionid") String sessionid, @PathVariable("supplierId") int supplierId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getSupplier");
		LOGGER.info("Getting Supplier for Supplier Id " + supplierId);
		LOGGER.info("Getting Supplier IN"); 
		return service.getSupplier(supplierId, new Response());
	}
	
	@Operation(description = "Get All Suppliers")
	@GetMapping(path = "/getAllSuppliers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllDishes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllSuppliers");
		LOGGER.info("Getting All Suppliers ");
		LOGGER.info("Getting All Suppliers IN"); 
		return service.getAllSuppliers(new Response());
	}
	
	@Operation(description = "Create Supplier")
	@PostMapping(path = "/createSupplier", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createSupplier(@RequestHeader("sessionid") String sessionid, @RequestBody CreateSupplierRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createSupplier");
		LOGGER.info("Creating Supplier for Supplier name "+request.getName());
		LOGGER.info("Create Supplier IN"); 
		return service.createSupplier(request, new Response());
	}
	
	@Operation(description = "Update Supplier")
	@PostMapping(path = "/updateSupplier/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateSupplier(@RequestHeader("sessionid") String sessionid, @RequestBody CreateSupplierRequest request
			, @PathVariable("supplierId") int supplierId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "updateSupplier");
		LOGGER.info("Updating Supplier for Supplier Id "+supplierId);
		LOGGER.info("Update Supplier IN"); 
		return service.updateSupplier(supplierId, request, new Response());
	}
	
	@Operation(description = "Delete Supplier")
	@DeleteMapping(path = "/deleteSupplier/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteSupplier(@RequestHeader("sessionid") String sessionid, @PathVariable("supplierId") int supplierId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteSupplier");
		LOGGER.info("Deleting Supplier for Supplier id "+supplierId);
		LOGGER.info("Delete Supplier IN"); 
		return service.deleteSupplier(supplierId, new Response());
	}

}
