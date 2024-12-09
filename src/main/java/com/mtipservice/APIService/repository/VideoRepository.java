package com.mtipservice.APIService.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtipservice.APIService.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
	@Query("Select vi from Video vi where vi.id.language = :language and vi.id.type = :type")
	Video getVideo(@Param("language") String language, @Param("type") String type);

	@Query("Select vi from Video vi where vi.id.language = :language")
	ArrayList<Video> getVideosFromLanguage(@Param("language") String language);

	@Query("delete from Video vi where vi.id.language = :language")
	void deleteVideosUsingLanguage(@Param("language") String language);

}
