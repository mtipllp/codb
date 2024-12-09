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

import com.mtipservice.APIService.entity.CreateIngredientRequest;
import com.mtipservice.APIService.entity.Errors;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.Ingredient;
import com.mtipservice.APIService.model.IngredientsSupplier;
import com.mtipservice.APIService.model.IngredientsSupplierPK;
import com.mtipservice.APIService.repository.IngredientRepository;
import com.mtipservice.APIService.repository.IngredientSupplierRepository;

@Service
public class IngredientService {
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	IngredientSupplierRepository ingredientSupplierRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(IngredientService.class);
	
	public ResponseEntity<Response> getIngredient(int ingredientDocId, Response res) {
		try {
			Ingredient ingr = ingredientRepository.getIngredient(ingredientDocId);
			res.setResponse(ingr);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getIngredients(ArrayList<Integer> ingredientDocIdList, Response res) {
		try {
			ArrayList<Ingredient> ingrList = ingredientRepository.getAllIngredients(ingredientDocIdList);
			res.setResponse(ingrList);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Ingredients has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Ingredients has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getAllIngredients(Response res) {
		try {
			List<Ingredient> ingredients = ingredientRepository.findAll();
			res.setResponse(ingredients);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Get all Ingredients has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Ger all Ingredients has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> createIngredient(CreateIngredientRequest request, Response res) {
		try {
			Ingredient ingredient = new Ingredient();
			BeanUtils.copyProperties(request, ingredient);
			ingredientRepository.save(ingredient);
			String resp = "Create Ingredient ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Create Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}


	public ResponseEntity<Response> updateIngredient(int ingredientId, CreateIngredientRequest request, Response res) {
		try {
			Ingredient ingredient = ingredientRepository.getIngredient(ingredientId);
			BeanUtils.copyProperties(request, ingredient);
			ingredientRepository.save(ingredient);
			String resp = "Update Ingredient ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Update Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> deleteIngredient(int ingredientId, Response res) {
		try {
			ingredientRepository.deleteIngredient(ingredientId);
			String resp = "Delete Ingredient ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Delete Ingredient has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Ingredient has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> ingredientSupplierAssociation(int ingredientid, int supplierid, Response res) {
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
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for IngredientSupplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for IngredientSupplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getSuppliersOfIngredients(int ingredientid, Response res) {
		try {
			ArrayList<IngredientsSupplier> ingsupList = ingredientSupplierRepository.getSuppliersForIngredient(ingredientid);
			res.setResponse(ingsupList);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Suppliers of Ingredients has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Suppliers of Ingredients has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
		
	}
	
	public ResponseEntity<Response> getIngredientsOfSupplier(int supplierid, Response res) {
		try {
			ArrayList<IngredientsSupplier> ingsupList = ingredientSupplierRepository.getIngredientsForSupplier(supplierid);
			res.setResponse(ingsupList);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Ingredients of Supplier has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Ingredients of Supplier has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
		
	}
}
