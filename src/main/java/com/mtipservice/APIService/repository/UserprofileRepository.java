package com.mtipservice.APIService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.entity.ClientCredentials;
import com.mtipservice.APIService.model.Userprofile;

@Repository
public interface UserprofileRepository extends JpaRepository<Userprofile, Integer> {
	@Query("Select up from Userprofile up where up.docid = :docid")
	Userprofile getUserprofile(@Param("docid") int docid);
	
	@Query("delete from Userprofile up where up.docid = :docid")
	void deleteUserprofile(@Param("docid") int docid);

	@Query("Select isStartupVideoPlayed from Userprofile up where up.docid = :docid")
	byte getIsStartupVideoPlayed(@Param("docid") int docid);
	
	@Query("Select up from Userprofile up where up.username = :username")
	Userprofile getUserprofileFromUsername(@Param("username") String username);

	@Query("Select up from Userprofile up where up.clientId = :clientId")
	Userprofile getUserprofileFromClientId(@Param("clientId") String clientId);

	@Query("Select up from Userprofile up where up.deviceId = :deviceId")
	Userprofile getUserprofileFromDeviceId(@Param("deviceId") String deviceId);
	
	@Query("Select new com.mtipservice.APIService.entity.ClientCredentials(up.docid, up.clientId, up.clientSecret, up.clientType) from Userprofile up where up.docid = :docid")
	ClientCredentials getClientCredentials(@Param("docid") int docid);
}
