package com.mtipservice.APIService.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
	@Query("Select di from Dish di where di.docid = :docid")
	Dish getDish(@Param("docid") int docid);
	
	@Query("delete from Dish di where di.docid = :docid")
	void deleteDish(@Param("docid") int docid);
	
	@Query("Select di from Dish di where di.name = :dishname")
	ArrayList<Dish> getDishByDishName(@Param("dishname") String dishname);
}
