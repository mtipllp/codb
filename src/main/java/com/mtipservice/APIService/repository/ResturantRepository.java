package com.mtipservice.APIService.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.Resturant;

@Repository
public interface ResturantRepository extends JpaRepository<Resturant, Integer> {
	@Query("Select re from Resturant re where re.docid = :docid")
	Resturant getResturant(@Param("docid") int docid);
	
	@Query("delete from Resturant re where re.docid = :docid")
	void deleteResturant(@Param("docid") int docid);

	@Query("Select re from Resturant re where re.docid in (Select redi.id.resId from ResturantDish redi where redi.id.dishId = :dishId)")
	ArrayList<Resturant> getResturantsForDish(@Param("dishId") int dishId);

	@Query("Select re from Resturant re where re.location = :location")
	ArrayList<Resturant> getResturantsForLocation(@Param("location") String location);

}
