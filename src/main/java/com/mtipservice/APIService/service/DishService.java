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

import com.mtipservice.APIService.entity.CreateDishRequest;
import com.mtipservice.APIService.entity.Errors;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.Dish;
import com.mtipservice.APIService.repository.DishRepository;

@Service
public class DishService {
	
	@Autowired
	DishRepository dishRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(DishService.class);
	
	public ResponseEntity<Response> getDish(int dishDocId, Response res) {
		try {
			Dish dish = dishRepository.getDish(dishDocId);
			res.setResponse(dish);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> getDishByDishName(String dishname, Response res) {
		try {
			ArrayList<Dish> dish = dishRepository.getDishByDishName(dishname);
			if(dish!=null && dish.size() > 0) {
				if(dish.size() == 1) {
					res.setResponse(dish.get(0));
					return ResponseEntity.status(HttpStatus.OK).body(res);		
				} else {
					Errors err = new Errors();
					err.setCode("ERR001");
					err.setMessage("Searching for Dish has too many results");
					err.setSource(this.getClass().getName());
					res.setErr(err);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(res);
				}
			} else {
				Errors err = new Errors();
				err.setCode("ERR001");
				err.setMessage("Searching for Dish has no data found");
				err.setSource(this.getClass().getName());
				res.setErr(err);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
				
			}
			
		}catch (Exception e) {
			LOGGER.error("Searching for Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getAllDishes(Response res) {
		try {
			List<Dish> dishes = dishRepository.findAll();
			res.setResponse(dishes);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Dishes has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> createDish(CreateDishRequest request, Response res) {
		try {
			Dish dish = new Dish();
			BeanUtils.copyProperties(request, dish);
			dishRepository.save(dish);
			String resp = "Create dish ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Create Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}


	public ResponseEntity<Response> updateDish(int dishId, CreateDishRequest request, Response res) {
		try {
			Dish dish = dishRepository.getDish(dishId);
			BeanUtils.copyProperties(request, dish);
			dishRepository.save(dish);
			String resp = "Update dish ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Update Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> deleteDish(int dishId, Response res) {
		try {
			dishRepository.deleteDish(dishId);
			String resp = "Delete dish ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Delete Dish has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Dish has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
}
