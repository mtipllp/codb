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
import com.mtipservice.APIService.entity.CreateDishRequest;
import com.mtipservice.APIService.entity.CreateIngredientRequest;
import com.mtipservice.APIService.entity.CreateResturantRequest;
import com.mtipservice.APIService.entity.CreateSessiondataRequest;
import com.mtipservice.APIService.entity.CreateStartupImageRequest;
import com.mtipservice.APIService.entity.CreateSupplierRequest;
import com.mtipservice.APIService.entity.CreateUserProfileRequest;
import com.mtipservice.APIService.entity.CreateVideoRequest;
import com.mtipservice.APIService.entity.Errors;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.Dish;
import com.mtipservice.APIService.model.Ingredient;
import com.mtipservice.APIService.model.IngredientsSupplier;
import com.mtipservice.APIService.model.IngredientsSupplierPK;
import com.mtipservice.APIService.model.Resturant;
import com.mtipservice.APIService.model.Sessiondata;
import com.mtipservice.APIService.model.StartupImage;
import com.mtipservice.APIService.model.Supplier;
import com.mtipservice.APIService.model.Userprofile;
import com.mtipservice.APIService.model.Video;
import com.mtipservice.APIService.model.VideoPK;
import com.mtipservice.APIService.repository.DishRepository;
import com.mtipservice.APIService.repository.IngredientRepository;
import com.mtipservice.APIService.repository.IngredientSupplierRepository;
import com.mtipservice.APIService.repository.ResturantRepository;
import com.mtipservice.APIService.repository.SessiondataRepository;
import com.mtipservice.APIService.repository.StartupImageRepository;
import com.mtipservice.APIService.repository.SupplierRepository;
import com.mtipservice.APIService.repository.UserprofileRepository;
import com.mtipservice.APIService.repository.VideoRepository;

@Service
public class APIWorkService {
	
	@Autowired
	DishRepository dishRepository;
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	ResturantRepository resturantRepository;
	
	@Autowired
	StartupImageRepository startupImageRepository;
	
	@Autowired
	SupplierRepository supplierRepository;
	
	@Autowired
	UserprofileRepository userprofileRepository;
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	IngredientSupplierRepository ingredientSupplierRepository;
	
	@Autowired
	SessiondataRepository sessiondataRepository;
	
/*	public IngredientsResponse getIngredients(String dishName) {
		IngredientsResponse response = new IngredientsResponse();
		Ingredient ing = new Ingredient();
		ing.setName("salt");
		ing.setType("salt");
		ing.setQtytype("grms");
		ing.setQty(10);
		Ingredient ing2 = new Ingredient();
		ing.setName("pepper");
		ing.setType("spice");
		ing.setQtytype("grms");
		ing.setQty(5);
		ArrayList<Ingredient> ingList = new ArrayList<>();
		ingList.addAll(List.of(ing, ing2));
		response.setIngredirntList(ingList);
		return response;
	}*/


	private static final Logger LOGGER = LoggerFactory.getLogger(APIWorkService.class);
	
	public ResponseEntity<Dish> getDish(int dishDocId, Response res) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(dishRepository.getDish(dishDocId));
		}catch (Exception e) {
			LOGGER.error("Searching for Dish has errored OUT with error-:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Dish());

		}
	}

	public ResponseEntity<ArrayList<Dish>> getDishByDishName(String dishname, Response res) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(dishRepository.getDishByDishName(dishname));
			} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}
	
	public ResponseEntity<List<Dish>> getAllDishes(Response res) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(dishRepository.findAll());
		}catch (Exception e) {
			LOGGER.error("Searching for Dishes has errored OUT with error-:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}

	public ResponseEntity<String> createDish(CreateDishRequest request, Response res) {
		try {
			Dish dish = new Dish();
			BeanUtils.copyProperties(request, dish);
			dishRepository.save(dish);
			String resp = "Create dish ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Create Dish has errored OUT with error-:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Dish has errored OUT with error-:" + e.getMessage());

		}
	}


	public ResponseEntity<String> updateDish(int dishId, CreateDishRequest request, Response res) {
		try {
			Dish dish = dishRepository.getDish(dishId);
			BeanUtils.copyProperties(request, dish);
			dishRepository.save(dish);
			String resp = "Update dish ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body("Update dish ended successfully");
		}catch (Exception e) {
			LOGGER.error("Update Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Dish has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<String> deleteDish(int dishId, Response res) {
		try {
			dishRepository.deleteDish(dishId);
			String resp = "Delete dish ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body("Delete dish ended successfully");
		}catch (Exception e) {
			LOGGER.error("Delete Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Dish has errored OUT with error-:" + e.getMessage());

		}
	}
	public ResponseEntity<Ingredient> getIngredient(int ingredientDocId, Response res) {
		try {
			Ingredient ingr = ingredientRepository.getIngredient(ingredientDocId);
			res.setResponse(ingr);
			return ResponseEntity.status(HttpStatus.OK).body(ingr);
		}catch (Exception e) {
			LOGGER.error("Searching for Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Ingredient());

		}
	}
	
	public ResponseEntity<ArrayList<Ingredient>> getIngredients(ArrayList<Integer> ingredientDocIdList, Response res) {
		try {
			ArrayList<Ingredient> ingrList = ingredientRepository.getAllIngredients(ingredientDocIdList);
			res.setResponse(ingrList);
			return ResponseEntity.status(HttpStatus.OK).body(ingrList);
		}catch (Exception e) {
			LOGGER.error("Searching for Ingredients has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Ingredients has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}
	
	public ResponseEntity<List<Ingredient>> getAllIngredients(Response res) {
		try {
			List<Ingredient> ingredients = ingredientRepository.findAll();
			res.setResponse(ingredients);
			return ResponseEntity.status(HttpStatus.OK).body(ingredients);
		}catch (Exception e) {
			LOGGER.error("Get all Ingredients has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Ger all Ingredients has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}

	public ResponseEntity<String> createIngredient(CreateIngredientRequest request, Response res) {
		try {
			Ingredient ingredient = new Ingredient();
			BeanUtils.copyProperties(request, ingredient);
			ingredientRepository.save(ingredient);
			String resp = "Create Ingredient ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body("Create Ingredient ended successfully");
		}catch (Exception e) {
			LOGGER.error("Create Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Ingredient has errored OUT with error-:" + e.getMessage());

		}
	}


	public ResponseEntity<String> updateIngredient(int ingredientId, CreateIngredientRequest request, Response res) {
		try {
			Ingredient ingredient = ingredientRepository.getIngredient(ingredientId);
			BeanUtils.copyProperties(request, ingredient);
			ingredientRepository.save(ingredient);
			String resp = "Update Ingredient ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Update Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Ingredient has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<String> deleteIngredient(int ingredientId, Response res) {
		try {
			ingredientRepository.deleteIngredient(ingredientId);
			String resp = "Delete Ingredient ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body("Delete Ingredient ended successfully");
		}catch (Exception e) {
			LOGGER.error("Delete Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Ingredient has errored OUT with error-:" + e.getMessage());

		}
	}

	public ResponseEntity<IngredientsSupplier> ingredientSupplierAssociation(int ingredientid, int supplierid, Response res) {
		try {
			IngredientsSupplier ingsup = ingredientSupplierRepository.getIngredient(ingredientid, supplierid);
			if(ingsup == null) {
				ingsup = new IngredientsSupplier();
				IngredientsSupplierPK pk = new IngredientsSupplierPK();
				pk.setIngId(ingredientid);
				pk.setSuppId(supplierid);
				ingsup.setId(pk);
				ingredientSupplierRepository.save(ingsup);
			}
			res.setResponse(ingsup);
			return ResponseEntity.status(HttpStatus.OK).body(ingsup);
		}catch (Exception e) {
			LOGGER.error("Searching for IngredientSupplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for IngredientSupplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new IngredientsSupplier());

		}
	}
	
	public ResponseEntity<ArrayList<IngredientsSupplier>> getSuppliersOfIngredients(int ingredientid, Response res) {
		try {
			ArrayList<IngredientsSupplier> ingsupList = ingredientSupplierRepository.getSuppliersForIngredient(ingredientid);
			res.setResponse(ingsupList);
			return ResponseEntity.status(HttpStatus.OK).body(ingsupList);
		}catch (Exception e) {
			LOGGER.error("Searching for Suppliers of Ingredients has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Suppliers of Ingredients has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
		
	}
	
	public ResponseEntity<ArrayList<IngredientsSupplier>> getIngredientsOfSupplier(int supplierid, Response res) {
		try {
			ArrayList<IngredientsSupplier> ingsupList = ingredientSupplierRepository.getIngredientsForSupplier(supplierid);
			res.setResponse(ingsupList);
			return ResponseEntity.status(HttpStatus.OK).body(ingsupList);
		}catch (Exception e) {
			LOGGER.error("Searching for Ingredients of Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Ingredients of Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
		
	}
	public ResponseEntity<Resturant> getResturant(int resturantDocId, Response res) {
		try {
			Resturant rest = resturantRepository.getResturant(resturantDocId);
			res.setResponse(rest);
			return ResponseEntity.status(HttpStatus.OK).body(rest);
		}catch (Exception e) {
			LOGGER.error("Searching for Resturant has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Resturant has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Resturant());

		}
	}
	
	public ResponseEntity<ArrayList<Resturant>> getResturantsFromDish(int dishId, Response res) {
		try {
			ArrayList<Resturant> restList = resturantRepository.getResturantsForDish(dishId);
			res.setResponse(restList);
			return ResponseEntity.status(HttpStatus.OK).body(restList);
		}catch (Exception e) {
			LOGGER.error("Searching for Resturants from Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Resturants from Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}
	
	public ResponseEntity<List<Resturant>> getAllResturants(Response res) {
		try {
			List<Resturant> resturants = resturantRepository.findAll();
			res.setResponse(resturants);
			return ResponseEntity.status(HttpStatus.OK).body(resturants);
		}catch (Exception e) {
			LOGGER.error("Get all Resturants has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Ger all Resturant has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}
	
	public ResponseEntity<List<Resturant>> getAllResturantsAtLocation(String location, Response res) {
		try {
			List<Resturant> resturants = resturantRepository.getResturantsForLocation(location);
			res.setResponse(resturants);
			return ResponseEntity.status(HttpStatus.OK).body(resturants);
		}catch (Exception e) {
			LOGGER.error("Get all Resturants From Location has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Ger all Resturant has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}

	public ResponseEntity<String> createResturant(CreateResturantRequest request, Response res) {
		try {
			Resturant rest = new Resturant();
			BeanUtils.copyProperties(request, rest);
			resturantRepository.save(rest);
			String resp = "Create Resturant ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body("Create Resturant ended successfully");
		}catch (Exception e) {
			LOGGER.error("Create Resturant has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Resturant has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Resturant has errored OUT with error-:" + e.getMessage());

		}
	}


	public ResponseEntity<String> updateResturant(int resturantId, CreateResturantRequest request, Response res) {
		try {
			Resturant resturant = resturantRepository.getResturant(resturantId);
			BeanUtils.copyProperties(request, resturant);
			resturantRepository.save(resturant);
			String resp = "Update Resturant ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Update Resturant has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Resturant has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Resturant has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<String> deleteResturant(int resturantId, Response res) {
		try {
			resturantRepository.deleteResturant(resturantId);
			String resp = "Delete Resturant ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body("Delete Resturant ended successfully");
		}catch (Exception e) {
			LOGGER.error("Delete Resturant has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Resturant has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Resturant has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<StartupImage> getStartupImage(int startImgDocId, Response res) {
		try {
			StartupImage startImg = startupImageRepository.getStartupImage(startImgDocId);
			res.setResponse(startImg);
			return ResponseEntity.status(HttpStatus.OK).body(startImg);
		}catch (Exception e) {
			LOGGER.error("Searching for StartupImage has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for StartupImage has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StartupImage());

		}
	}

	public ResponseEntity<StartupImage> getStartupImageByLanguage(String language, Response res) {
		try {
			StartupImage startupImage = startupImageRepository.getStartupImageFromLanguage(language);
			res.setResponse(startupImage);
			return ResponseEntity.status(HttpStatus.OK).body(startupImage);
			
		}catch (Exception e) {
			LOGGER.error("Searching for Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new StartupImage());

		}
	}
	
	public ResponseEntity<List<StartupImage>> getAllStartupImages(Response res) {
		try {
			List<StartupImage> dishes = startupImageRepository.findAll();
			res.setResponse(dishes);
			return ResponseEntity.status(HttpStatus.OK).body(dishes);
		}catch (Exception e) {
			LOGGER.error("Searching for All Startup Images has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for All Startup Images has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}

	public ResponseEntity<String> createStartupImages(CreateStartupImageRequest request, Response res) {
		try {
			StartupImage startupImage = new StartupImage();
			BeanUtils.copyProperties(request, startupImage);
			startupImageRepository.save(startupImage);
			String resp = "Create Startup Image ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Create Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Startup Image has errored OUT with error-:" + e.getMessage());

		}
	}


	public ResponseEntity<String> updateStartupImage(int startupImageId, CreateStartupImageRequest request, Response res) {
		try {
			StartupImage startupImage = startupImageRepository.getStartupImage(startupImageId);
			BeanUtils.copyProperties(request, startupImage);
			startupImageRepository.save(startupImage);
			String resp = "Update Startup Image ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Update Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Startup Image has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<String> deleteStartupImage(int startupImageId, Response res) {
		try {
			startupImageRepository.deleteStartupImage(startupImageId);
			String resp = "Delete Startup Image ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Delete Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Startup Image has errored OUT with error-:" + e.getMessage());

		}
	}
	public ResponseEntity<Supplier> getSupplier(int supplierDocId, Response res) {
		try {
			Supplier supp = supplierRepository.getSupplier(supplierDocId);
			res.setResponse(supp);
			return ResponseEntity.status(HttpStatus.OK).body(supp);
		}catch (Exception e) {
			LOGGER.error("Searching for Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Supplier());

		}
	}
	
	public ResponseEntity<List<Supplier>> getAllSuppliers(Response res) {
		try {
			List<Supplier> suppliers = supplierRepository.findAll();
			res.setResponse(suppliers);
			return ResponseEntity.status(HttpStatus.OK).body(suppliers);
		}catch (Exception e) {
			LOGGER.error("Searching for Suppliers has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}

	public ResponseEntity<String> createSupplier(CreateSupplierRequest request, Response res) {
		try {
			Supplier supplier = new Supplier();
			BeanUtils.copyProperties(request, supplier);
			supplierRepository.save(supplier);
			String resp = "Create Supplier ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Create Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Supplier has errored OUT with error-:" + e.getMessage());

		}
	}


	public ResponseEntity<String> updateSupplier(int supplierId, CreateSupplierRequest request, Response res) {
		try {
			Supplier supplier = supplierRepository.getSupplier(supplierId);
			BeanUtils.copyProperties(request, supplier);
			supplierRepository.save(supplier);
			String resp = "Update Supplier ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Update Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Supplier has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<String> deleteSupplier(int supplierId, Response res) {
		try {
			supplierRepository.deleteSupplier(supplierId);
			String resp = "Delete supplier ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Delete supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete supplier has errored OUT with error-:" + e.getMessage());

		}
	}
	public ResponseEntity<Userprofile> getUserprofile(int UserprofileDocId, Response res) {
		try {
			Userprofile userpr = userprofileRepository.getUserprofile(UserprofileDocId);
			res.setResponse(userpr);
			return ResponseEntity.status(HttpStatus.OK).body(userpr);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Userprofile());

		}
	}
	
	public ResponseEntity<List<Userprofile>> getAllUserprofiles(Response res) {
		try {
			List<Userprofile> userprofiles = userprofileRepository.findAll();
			res.setResponse(userprofiles);
			return ResponseEntity.status(HttpStatus.OK).body(userprofiles);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofiles has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}

	public ResponseEntity<String> createUserprofile(CreateUserProfileRequest request, Response res) {
		try {
			Userprofile userprofile = new Userprofile();
			BeanUtils.copyProperties(request, userprofile);
			userprofileRepository.save(userprofile);
			String resp = "Create Userprofile ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Create Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Userprofile has errored OUT with error-:" + e.getMessage());

		}
	}


	public ResponseEntity<String> updateUserprofile(int UserprofileId, CreateUserProfileRequest request, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofile(UserprofileId);
			BeanUtils.copyProperties(request, userprofile);
			userprofileRepository.save(userprofile);
			String resp = "Update Userprofile ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Update Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Userprofile has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<String> deleteUserprofile(int UserprofileId, Response res) {
		try {
			userprofileRepository.deleteUserprofile(UserprofileId);
			String resp = "Delete Userprofile ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Delete Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Userprofile has errored OUT with error-:" + e.getMessage());

		}
	}

	public ResponseEntity<Userprofile> getUserProfileFromUsername(String username, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofileFromUsername(username);
			res.setResponse(userprofile);
			return ResponseEntity.status(HttpStatus.OK).body(userprofile);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Userprofile());

		}
	}

	public ResponseEntity<Userprofile> getUserProfileFromClientId(String clientid, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofileFromClientId(clientid);
			res.setResponse(userprofile);
			return ResponseEntity.status(HttpStatus.OK).body(userprofile);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Userprofile());

		}
	}

	public ResponseEntity<Userprofile> getUserProfileFromDeviceId(String deviceid, Response res) {
		try {
			Userprofile userprofile = userprofileRepository.getUserprofileFromDeviceId(deviceid);
			res.setResponse(userprofile);
			return ResponseEntity.status(HttpStatus.OK).body(userprofile);
		}catch (Exception e) {
			LOGGER.error("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Userprofile has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Userprofile());

		}
	}
	
	public ResponseEntity<ClientCredentials> getClientCredentials(int userProfileId, Response res) {
		try {
			ClientCredentials clientCredentials = userprofileRepository.getClientCredentials(userProfileId);
			res.setResponse(clientCredentials);
			return ResponseEntity.status(HttpStatus.OK).body(clientCredentials);
		}catch (Exception e) {
			LOGGER.error("Getting Client Credentials has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Getting Client Credentials has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ClientCredentials());

		}
		
	}
	
	public ResponseEntity<Sessiondata> createOrUpdateSessionInfo(CreateSessiondataRequest request, Response res) {
		try {
			Sessiondata sd = sessiondataRepository.getSessiondata(request.getSession());
			if(sd == null) {
				sd = new Sessiondata();
			}
			BeanUtils.copyProperties(request, sd);
			sessiondataRepository.save(sd);
			res.setResponse(sd);
			return ResponseEntity.status(HttpStatus.OK).body(sd);
		} catch (Exception e) {
			LOGGER.error("Create Or Update Session Info has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Or Update Session Info has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Sessiondata());

		}
	}
	
	public ResponseEntity<ArrayList<Sessiondata>> getAllSessionsFromUserId(int userprofileId, Response res) {
		try {
			ArrayList<Sessiondata> sdList = sessiondataRepository.getSessiondataFromUserprofileid(userprofileId);
			res.setResponse(sdList);
			return ResponseEntity.status(HttpStatus.OK).body(sdList);
		} catch (Exception e) {
			LOGGER.error("Get All Session Info from User Profile Id has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Get All Session Info from User Profile Id has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
		
	}
	public ResponseEntity<Video> getVideo(String language, String type, Response res) {
		try {
			Video vid = videoRepository.getVideo(language, type);
			res.setResponse(vid);
			return ResponseEntity.status(HttpStatus.OK).body(vid);
		}catch (Exception e) {
			LOGGER.error("Searching for Video has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Video());

		}
	}
	
	public ResponseEntity<List<Video>> getAllVideos(Response res) {
		try {
			List<Video> Videos = videoRepository.findAll();
			res.setResponse(Videos);
			return ResponseEntity.status(HttpStatus.OK).body(Videos);
		}catch (Exception e) {
			LOGGER.error("Searching for Videos has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	}

	public ResponseEntity<String> createVideo(CreateVideoRequest request, Response res) {
		try {
			Video video = new Video();
			VideoPK videoPk = new VideoPK();
			videoPk.setLanguage(request.getLanguage());
			videoPk.setType(request.getType());
			video.setId(videoPk);
			video.setAudioLink(request.getAudioLink());
			video.setComments(request.getComments());
			video.setDishId(request.getDishId());
			video.setLink(request.getLink());
			videoRepository.save(video);
			String resp = "Create Video ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Create Video has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Create Video has errored OUT with error-:" + e.getMessage());

		}
	}


	public ResponseEntity<String> updateVideo(String language, String type, CreateVideoRequest request, Response res) {
		try {
			Video video = videoRepository.getVideo(language, type);
			BeanUtils.copyProperties(request, video);
			video.setAudioLink(request.getAudioLink());
			video.setComments(request.getComments());
			video.setDishId(request.getDishId());
			video.setLink(request.getLink());
			videoRepository.save(video);
			String resp = "Update Video ended successfully";
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}catch (Exception e) {
			LOGGER.error("Update Video has errored OUT with error-:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update Video has errored OUT with error-:" + e.getMessage());

		}
	}
	
	public ResponseEntity<String> deleteVideo(String language, String type, Response res) {
		try {
			Video video = videoRepository.getVideo(language, type);
			videoRepository.delete(video);
			return ResponseEntity.status(HttpStatus.OK).body("Delete Video ended successfully");
		}catch (Exception e) {
			LOGGER.error("Delete Video has errored OUT with error-:" + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete Video has errored OUT with error-:" + e.getMessage());

		}
	}

}
