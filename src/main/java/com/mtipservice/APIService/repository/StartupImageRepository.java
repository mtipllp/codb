package com.mtipservice.APIService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.StartupImage;

@Repository
public interface StartupImageRepository extends JpaRepository<StartupImage, Integer> {
	@Query("Select si from StartupImage si where si.docid = :docid")
	StartupImage getStartupImage(@Param("docid") int docid);

	@Query("Select si from StartupImage si where si.language = :language")
	StartupImage getStartupImageFromLanguage(@Param("language") String language);

	@Query("delete from StartupImage si where si.docid = :docid")
	void deleteStartupImage(@Param("docid") int docid);
}
