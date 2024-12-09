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
import com.mtipservice.APIService.entity.ClientCredentials;
import com.mtipservice.APIService.entity.CreateDishRequest;
import com.mtipservice.APIService.entity.CreateIngredientRequest;
import com.mtipservice.APIService.entity.CreateResturantRequest;
import com.mtipservice.APIService.entity.CreateSessiondataRequest;
import com.mtipservice.APIService.entity.CreateStartupImageRequest;
import com.mtipservice.APIService.entity.CreateSupplierRequest;
import com.mtipservice.APIService.entity.CreateUserProfileRequest;
import com.mtipservice.APIService.entity.CreateVideoRequest;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.Dish;
import com.mtipservice.APIService.model.Ingredient;
import com.mtipservice.APIService.model.IngredientsSupplier;
import com.mtipservice.APIService.model.Resturant;
import com.mtipservice.APIService.model.Sessiondata;
import com.mtipservice.APIService.model.StartupImage;
import com.mtipservice.APIService.model.Supplier;
import com.mtipservice.APIService.model.Userprofile;
import com.mtipservice.APIService.model.Video;
import com.mtipservice.APIService.service.APIWorkService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@CrossOrigin
public class APIController {
	@Autowired
	APIWorkService service;


	private static final Logger LOGGER = LoggerFactory.getLogger(APIController.class);

	@Operation(description = "Get Dish")
	@GetMapping(path = "/dummygetDish/{dishid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dish> getDish(@RequestHeader("sessionid") String sessionid, @PathVariable("dishId") int dishId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getDish");
		LOGGER.info("Getting Dish for Dish Id " + dishId);
		LOGGER.info("Getting Dish IN"); 
		return service.getDish(dishId, new Response());
	}
	
	@Operation(description = "Get Dish By Dish Name")
	@GetMapping(path = "/dummygetDishByDishName/{dishname}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Dish>> getDishByDishName(@RequestHeader("sessionid") String sessionid, @PathVariable("dishname") String dishname) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getDishByDishName");
		LOGGER.info("Getting Dish for Dish Name " + dishname);
		LOGGER.info("Getting Dish IN"); 
		return service.getDishByDishName(dishname, new Response());
	}
	
	@Operation(description = "Get All Dishes")
	@GetMapping(path = "/dummygetAllDishes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dish>> getAllDishes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllDishes");
		LOGGER.info("Getting All Dishes ");
		LOGGER.info("Getting All Dishes IN"); 
		return service.getAllDishes(new Response());
	}
	
	@Operation(description = "Create Dish")
	@PostMapping(path = "/dummycreateDish", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createDish(@RequestHeader("sessionid") String sessionid, @RequestBody CreateDishRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createDish");
		LOGGER.info("Creating Dish for dish name "+request.getName());
		LOGGER.info("Create Dish IN"); 
		return service.createDish(request, new Response());
	}
	
	@Operation(description = "Update Dish")
	@PostMapping(path = "/dummyupdateDish/{dishId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateDish(@RequestHeader("sessionid") String sessionid, @RequestBody CreateDishRequest request
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
	@DeleteMapping(path = "/dummydeleteDish", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteDish(@RequestHeader("sessionid") String sessionid, @PathVariable("dishId") int dishId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteDish");
		LOGGER.info("Deleting Dish for dish id "+dishId);
		LOGGER.info("Delete Dish IN"); 
		return service.deleteDish(dishId, new Response());
	}

	@Operation(description = "Get Ingredient")
	@GetMapping(path = "/dummygetIngredient/{ingredientid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingredient> getIngredient(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getIngredient");
		LOGGER.info("Getting Ingredient for Ingredient Id " + ingredientId);
		LOGGER.info("Getting Ingredient IN"); 
		return service.getIngredient(ingredientId, new Response());
	}

	@Operation(description = "Get Ingredients of a dish")
	@PostMapping(path = "/dummygetIngredients/{ingredientIds}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Ingredient>> getIngredients(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientIds") List<Integer> ingredientIds) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getIngredients");
		LOGGER.info("Getting Ingredients for Ingredient Ids " + ingredientIds);
		LOGGER.info("Getting Ingredients IN"); 
		return service.getIngredients(new ArrayList<Integer>(ingredientIds), new Response());
	}
	
	@Operation(description = "Get All Ingredients")
	@GetMapping(path = "/dummygetAllIngredients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingredient>> getAllIngredients(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllIngredients");
		LOGGER.info("Getting All Ingredients ");
		LOGGER.info("Getting All Ingredients IN"); 
		return service.getAllIngredients(new Response());
	}
	
	@Operation(description = "Create Ingredient")
	@PostMapping(path = "/dummycreateIngredient", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createIngredient(@RequestHeader("sessionid") String sessionid, @RequestBody CreateIngredientRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createIngredient");
		LOGGER.info("Creating Ingredient for Ingredient name "+request.getName());
		LOGGER.info("Create Ingredient IN"); 
		return service.createIngredient(request, new Response());
	}
	
	@Operation(description = "Update Ingredient")
	@PostMapping(path = "/dummyupdateIngredient/{ingredientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateIngredient(@RequestHeader("sessionid") String sessionid, @RequestBody CreateIngredientRequest request
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
	@DeleteMapping(path = "/dummydeleteIngredient/{ingredientId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteIngredient(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteIngredient");
		LOGGER.info("Deleting Ingredient for Ingredient id "+ingredientId);
		LOGGER.info("Delete Ingredient IN"); 
		return service.deleteIngredient(ingredientId, new Response());
	}

	@Operation(description = "Insert or Get Ingredient Supplier")
	@PostMapping(path = "/dummyinsertOrGetIngredient/{ingredientId}/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IngredientsSupplier> insertOrGetIngredient(@RequestHeader("sessionid") String sessionid
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
	@GetMapping(path = "/dummygetSuppliersOfIngredient/{ingredientid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<IngredientsSupplier>> getSupplierOfIngredient(@RequestHeader("sessionid") String sessionid, @PathVariable("ingredientId") int ingredientId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getSupplierOfIngredient");
		LOGGER.info("Getting Supplier of Ingredient for Ingredient Id " + ingredientId);
		LOGGER.info("Getting Supplier of Ingredient IN"); 
		return service.getSuppliersOfIngredients(ingredientId, new Response());
	}

	@Operation(description = "Get Ingredient")
	@GetMapping(path = "/dummygetIngredientsOfSupplier/{supplierid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<IngredientsSupplier>> getIngredientsOfSupplier(@RequestHeader("sessionid") String sessionid, @PathVariable("supplierid") int supplierid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getIngredientsOfSupplier");
		LOGGER.info("Getting Ingredients of Supplier for Supplier Id " + supplierid);
		LOGGER.info("Getting Ingredients of Supplier IN"); 
		return service.getIngredientsOfSupplier(supplierid, new Response());
	}

	@Operation(description = "Get Resturant")
	@GetMapping(path = "/dummygetResturant/{resturantid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resturant> getResturant(@RequestHeader("sessionid") String sessionid, @PathVariable("resturantId") int resturantId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getResturant");
		LOGGER.info("Getting Resturant for Resturant Id " + resturantId);
		LOGGER.info("Getting Resturant IN"); 
		return service.getResturant(resturantId, new Response());
	}

	@Operation(description = "Get Resturants of a dish")
	@PostMapping(path = "/dummygetResturants/{dishid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Resturant>> getResturantsFromDish(@RequestHeader("sessionid") String sessionid, @PathVariable("dishid") int dishid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getResturantsFromDish");
		LOGGER.info("Getting Resturants for Dish Id " + dishid);
		LOGGER.info("Getting Resturants for Dish Id IN"); 
		return service.getResturantsFromDish(dishid, new Response());
	}

	@Operation(description = "Get Resturants at location")
	@PostMapping(path = "/dummygetResturants/{locationid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Resturant>> getResturantsAtLocation(@RequestHeader("sessionid") String sessionid, @PathVariable("location") String location) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getResturantsAtLocation");
		LOGGER.info("Getting Resturants at lcoation " + location);
		LOGGER.info("Getting Resturants at location IN"); 
		return service.getAllResturantsAtLocation(location, new Response());
	}

	@Operation(description = "Get All Resturants")
	@GetMapping(path = "/dummygetAllResturants", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Resturant>> getAllResturants(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllResturants");
		LOGGER.info("Getting All Resturants ");
		LOGGER.info("Getting All Resturants IN"); 
		return service.getAllResturants(new Response());
	}
	
	@Operation(description = "Create Resturant")
	@PostMapping(path = "/dummycreateResturant", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createResturant(@RequestHeader("sessionid") String sessionid, @RequestBody CreateResturantRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createResturant");
		LOGGER.info("Creating Resturant for Resturant name "+request.getName());
		LOGGER.info("Create Resturant IN"); 
		return service.createResturant(request, new Response());
	}
	
	@Operation(description = "Update Resturant")
	@PostMapping(path = "/dummyupdateResturant/{resturantId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateResturant(@RequestHeader("sessionid") String sessionid, @RequestBody CreateResturantRequest request
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
	@DeleteMapping(path = "/dummydeleteResturant/{ResturantId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteResturant(@RequestHeader("sessionid") String sessionid, @PathVariable("resturantId") int resturantId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteResturant");
		LOGGER.info("Deleting Resturant for Resturant id "+resturantId);
		LOGGER.info("Delete Resturant IN"); 
		return service.deleteResturant(resturantId, new Response());
	}

	@Operation(description = "Get StartupImage")
	@GetMapping(path = "/dummygetStartupImage/{startupImageid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StartupImage> getStartupImage(@RequestHeader("sessionid") String sessionid, @PathVariable("startupImageId") int startupImageId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getStartupImage");
		LOGGER.info("Getting StartupImage for startupImage Id " + startupImageId);
		LOGGER.info("Getting StartupImage IN"); 
		return service.getStartupImage(startupImageId, new Response());
	}

	@Operation(description = "Get StartupImage")
	@GetMapping(path = "/dummygetStartupImageByLanguage/{language}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StartupImage> getStartupImageByLanguage(@RequestHeader("sessionid") String sessionid, @PathVariable("language") String language) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getStartupImage");
		LOGGER.info("Getting StartupImage for language " + language);
		LOGGER.info("Getting StartupImage IN"); 
		return service.getStartupImageByLanguage(language, new Response());
	}
	
	@Operation(description = "Get All Startup Images")
	@GetMapping(path = "/dummygetAllStartup Images", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StartupImage>> getAllStartupImages(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllStartupImages");
		LOGGER.info("Getting All StartupImages ");
		LOGGER.info("Getting All StartupImages IN"); 
		return service.getAllStartupImages(new Response());
	}
	
	@Operation(description = "Create StartupImage")
	@PostMapping(path = "/dummycreateStartupImage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createStartupImage(@RequestHeader("sessionid") String sessionid, @RequestBody CreateStartupImageRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createStartupImage");
		LOGGER.info("Creating StartupImage for StartupImage "+request.toString());
		LOGGER.info("Create StartupImage IN"); 
		return service.createStartupImages(request, new Response());
	}
	
	@Operation(description = "Update StartupImage")
	@PostMapping(path = "/dummyupdateStartupImage/{startupImageId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateStartupImage(@RequestHeader("sessionid") String sessionid, @RequestBody CreateStartupImageRequest request
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
	@DeleteMapping(path = "/dummydeleteStartupImage/{startupImageId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteStartupImage(@RequestHeader("sessionid") String sessionid, @PathVariable("startupImageId") int startupImageId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteStartupImage");
		LOGGER.info("Deleting StartupImage for StartupImage id "+startupImageId);
		LOGGER.info("Delete StartupImage IN"); 
		return service.deleteStartupImage(startupImageId, new Response());
	}
	@Operation(description = "Get Supplier")
	@GetMapping(path = "/dummygetSupplier/{supplierid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Supplier> getSupplier(@RequestHeader("sessionid") String sessionid, @PathVariable("supplierId") int supplierId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getSupplier");
		LOGGER.info("Getting Supplier for Supplier Id " + supplierId);
		LOGGER.info("Getting Supplier IN"); 
		return service.getSupplier(supplierId, new Response());
	}
	
	@Operation(description = "Get All Suppliers")
	@GetMapping(path = "/dummygetAllSuppliers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Supplier>> getAllSuppliers(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllSuppliers");
		LOGGER.info("Getting All Suppliers ");
		LOGGER.info("Getting All Suppliers IN"); 
		return service.getAllSuppliers(new Response());
	}
	
	@Operation(description = "Create Supplier")
	@PostMapping(path = "/dummycreateSupplier", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createSupplier(@RequestHeader("sessionid") String sessionid, @RequestBody CreateSupplierRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createSupplier");
		LOGGER.info("Creating Supplier for Supplier name "+request.getName());
		LOGGER.info("Create Supplier IN"); 
		return service.createSupplier(request, new Response());
	}
	
	@Operation(description = "Update Supplier")
	@PostMapping(path = "/dummyupdateSupplier/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateSupplier(@RequestHeader("sessionid") String sessionid, @RequestBody CreateSupplierRequest request
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
	@DeleteMapping(path = "/dummydeleteSupplier/{supplierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteSupplier(@RequestHeader("sessionid") String sessionid, @PathVariable("supplierId") int supplierId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteSupplier");
		LOGGER.info("Deleting Supplier for Supplier id "+supplierId);
		LOGGER.info("Delete Supplier IN"); 
		return service.deleteSupplier(supplierId, new Response());
	}
	@Operation(description = "Get Userprofile")
	@GetMapping(path = "/dummygetUserprofile/{userprofileid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Userprofile> getUserprofile(@RequestHeader("sessionid") String sessionid, @PathVariable("userprofileId") int userprofileId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofile");
		LOGGER.info("Getting Userprofile for Userprofile Id " + userprofileId);
		LOGGER.info("Getting Userprofile IN"); 
		return service.getUserprofile(userprofileId, new Response());
	}

	@Operation(description = "Get Userprofile from username")
	@PostMapping(path = "/dummygetUserprofileUserName/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Userprofile> getUserprofilesFromUserName(@RequestHeader("sessionid") String sessionid, @PathVariable("username") String username) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromUserName");
		LOGGER.info("Getting Userprofiles for UserName " + username);
		LOGGER.info("Getting Userprofiles for UserName IN"); 
		return service.getUserProfileFromUsername(username, new Response());
	}

	@Operation(description = "Get Userprofile from clientid")
	@PostMapping(path = "/dummygetUserprofileClientId/{clientid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Userprofile> getUserprofilesFromClientId(@RequestHeader("sessionid") String sessionid, @PathVariable("clientid") String clientid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromClientId");
		LOGGER.info("Getting Userprofiles for ClientId " + clientid);
		LOGGER.info("Getting Userprofiles for Client Id IN"); 
		return service.getUserProfileFromClientId(clientid, new Response());
	}

	@Operation(description = "Get Userprofile from deviceid")
	@PostMapping(path = "/dummygetUserprofileDeviceId/{deviceid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Userprofile> getUserprofilesFromDeviceId(@RequestHeader("sessionid") String sessionid, @PathVariable("deviceid") String clientid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromClientId");
		LOGGER.info("Getting Userprofiles for ClientId " + clientid);
		LOGGER.info("Getting Userprofiles for Client Id IN"); 
		return service.getUserProfileFromClientId(clientid, new Response());
	}

	@Operation(description = "Get All Userprofiles")
	@GetMapping(path = "/dummygetAllUserprofiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Userprofile>> getAllUserProfiles(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllUserprofiles");
		LOGGER.info("Getting All Userprofiles ");
		LOGGER.info("Getting All Userprofiles IN"); 
		return service.getAllUserprofiles(new Response());
	}
	
	
	@Operation(description = "Create Userprofile")
	@PostMapping(path = "/dummycreateUserprofile", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createUserprofile(@RequestHeader("sessionid") String sessionid, @RequestBody CreateUserProfileRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createUserprofile");
		LOGGER.info("Create Userprofile for Userprofile device id "+request.getDeviceId());
		LOGGER.info("Create Userprofile IN"); 
		return service.createUserprofile(request, new Response());
	}
	
	@Operation(description = "Update Userprofile")
	@PostMapping(path = "/dummyupdateUserprofile/{userprofileId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateUserprofile(@RequestHeader("sessionid") String sessionid, @RequestBody CreateUserProfileRequest request
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
	@DeleteMapping(path = "/dummydeleteUserprofile/{userprofileId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteUserprofile(@RequestHeader("sessionid") String sessionid, @PathVariable("userprofileId") int userprofileId) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteUserprofile");
		LOGGER.info("Deleting Userprofile for Userprofile id "+userprofileId);
		LOGGER.info("Delete Userprofile IN"); 
		return service.deleteUserprofile(userprofileId, new Response());
	}

	@Operation(description = "Add or Update Session of User")
	@PostMapping(path = "/dummyaddOrUpdateSession", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sessiondata> addOrUpdateSession(@RequestHeader("sessionid") String sessionid, @RequestBody CreateSessiondataRequest request) {
		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "addOrUpdateSession");
		LOGGER.info("Add or update session information for user id "+request.getUserprofileid());
		LOGGER.info("Add or update session information for user id IN"); 
		return service.createOrUpdateSessionInfo(request, new Response());
	}
	

	@Operation(description = "Get All Session Data from userid")
	@PostMapping(path = "/dummygetAllSessionFromUserId/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Sessiondata>> getAllSessionFromUserId(@RequestHeader("sessionid") String sessionid, @PathVariable("userid") int userid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getUserprofilesFromUserName");
		LOGGER.info("Getting User Session Data for UserId " + userid);
		LOGGER.info("Getting User Session Data for UserId IN"); 
		return service.getAllSessionsFromUserId(userid, new Response());
	}
	
	@Operation(description = "Get Client Credentials")
	@GetMapping(path = "/dummygetClientcredentials/{userprofileid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientCredentials> getClientCredentials(@RequestHeader("sessionid") String sessionid, @PathVariable("userprofileid") int userprofileid) {
		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getClientCredentials");
		LOGGER.info("Getting Client Credentials for userprofileid " + userprofileid);
		LOGGER.info("Getting Client Credentials for userprofileid IN"); 
		return service.getClientCredentials(userprofileid, new Response());
		
	}
	@Operation(description = "Get Video")
	@GetMapping(path = "/dummygetVideo/{language}/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Video> getVideo(@RequestHeader("sessionid") String sessionid, @PathVariable("language") String language, @PathVariable("type") String type) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getVideo");
		LOGGER.info("Getting Video for Video language " + language + " and type " + type);
		LOGGER.info("Getting Video IN"); 
		return service.getVideo(language, type, new Response());
	}
	
	
	@Operation(description = "Get All Videoes")
	@GetMapping(path = "/dummygetAllVideos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Video>> getAllVideoes(@RequestHeader("sessionid") String sessionid) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "getAllVideoes");
		LOGGER.info("Getting All Videoes ");
		LOGGER.info("Getting All Videoes IN"); 
		return service.getAllVideos(new Response());
	}
	
	@Operation(description = "Create Video")
	@PostMapping(path = "/dummycreateVideo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createVideo(@RequestHeader("sessionid") String sessionid, @RequestBody CreateVideoRequest request) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "createVideo");
		LOGGER.info("Creating Video for Video language "+request.getLanguage());
		LOGGER.info("Create Video IN"); 
		return service.createVideo(request, new Response());
	}
	
	@Operation(description = "Update Video")
	@PostMapping(path = "/dummyupdateVideo/{videoId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateVideo(@RequestHeader("sessionid") String sessionid, @RequestBody CreateVideoRequest request
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
	@DeleteMapping(path = "/dummydeleteVideo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteVideo(@RequestHeader("sessionid") String sessionid, @PathVariable("language") String language, @PathVariable("type") String type) {

		MDC.clear();
		MDC.put(Constants.LOGGING_HEADER_SERVICE_NAME, Constants.LOGGING_SERVICE_NAME);
		MDC.put(Constants.LOGGING_HEADER_SESSION_ID, sessionid);
		MDC.put(Constants.LOGGING_HEADER_METHOD_ID, "deleteVideo");
		LOGGER.info("Deleting Video for language "+language + " and type "+ type);
		LOGGER.info("Delete Video IN"); 
		return service.deleteVideo(language, type, new Response());
	}

}
