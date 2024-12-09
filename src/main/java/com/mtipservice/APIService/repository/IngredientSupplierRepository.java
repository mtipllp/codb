package com.mtipservice.APIService.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.IngredientsSupplier;

@Repository
public interface IngredientSupplierRepository extends JpaRepository<IngredientsSupplier, Integer>{
	@Query("Select in from IngredientsSupplier in where in.id.ingId = :ingId and in.id.suppId = :suppId")
	IngredientsSupplier getIngredient(@Param("ingId") int ingId, @Param("suppId") int suppId);
	
	@Query("Select in from IngredientsSupplier in where in.id.ingId = :ingId")
	ArrayList<IngredientsSupplier> getSuppliersForIngredient(@Param("ingId") int ingId);

	@Query("Select in from IngredientsSupplier in where in.id.suppId = :suppId")
	ArrayList<IngredientsSupplier> getIngredientsForSupplier(@Param("suppId") int suppId);
}
