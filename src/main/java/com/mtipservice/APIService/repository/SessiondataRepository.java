package com.mtipservice.APIService.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.Sessiondata;

@Repository
public interface SessiondataRepository extends JpaRepository<Sessiondata, String> {

	@Query("Select sd from Sessiondata sd where sd.session = :session")
	Sessiondata getSessiondata(@Param("session") String session);
	
	@Query("Select sd from Sessiondata sd where sd.userprofileid = :userprofileid")
	ArrayList<Sessiondata> getSessiondataFromUserprofileid(@Param("userprofileid") int userprofileid);
}
