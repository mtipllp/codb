package com.mtipservice.APIService.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
	@Query("Select in from Ingredient in where in.docid = :docid")
	Ingredient getIngredient(@Param("docid") int docid);
	
	@Query("Select in from Ingredient in where in.docid in :docList")
	ArrayList<Ingredient> getAllIngredients(@Param("docList") ArrayList<Integer> docList);
	
	@Query("delete from Ingredient in where in.docid = :docid")
	void deleteIngredient(@Param("docid") int docid);
}
