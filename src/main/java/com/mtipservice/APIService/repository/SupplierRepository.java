package com.mtipservice.APIService.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	@Query("Select su from Supplier su where su.docid = :docid")
	Supplier getSupplier(@Param("docid") int docid);
	
	@Query("delete from Supplier su where su.docid = :docid")
	void deleteSupplier(@Param("docid") int docid);
	
	@Query("Select su from Supplier su where su.docid in (Select insu.id.suppId from IngredientsSupplier insu where insu.id.ingId = :docid)")
	ArrayList<Supplier> getSuppliersForIngredient(@Param("docid") int docid);
}
