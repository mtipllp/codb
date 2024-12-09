package com.mtipservice.APIService.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mtipservice.APIService.entity.CreateStartupImageRequest;
import com.mtipservice.APIService.entity.Errors;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.StartupImage;
import com.mtipservice.APIService.repository.StartupImageRepository;

@Service
public class StartupImageService {
	@Autowired
	StartupImageRepository startupImageRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(StartupImageService.class);
	
	public ResponseEntity<Response> getStartupImage(int startImgDocId, Response res) {
		try {
			StartupImage startImg = startupImageRepository.getStartupImage(startImgDocId);
			res.setResponse(startImg);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for StartupImage has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for StartupImage has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> getStartupImageByLanguage(String language, Response res) {
		try {
			StartupImage startupImage = startupImageRepository.getStartupImageFromLanguage(language);
			res.setResponse(startupImage);
			return ResponseEntity.status(HttpStatus.OK).body(res);
			
		}catch (Exception e) {
			LOGGER.error("Searching for Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getAllStartupImages(Response res) {
		try {
			List<StartupImage> dishes = startupImageRepository.findAll();
			res.setResponse(dishes);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for All Startup Images has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for All Startup Images has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> createStartupImages(CreateStartupImageRequest request, Response res) {
		try {
			StartupImage startupImage = new StartupImage();
			BeanUtils.copyProperties(request, startupImage);
			startupImageRepository.save(startupImage);
			String resp = "Create Startup Image ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Create Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}


	public ResponseEntity<Response> updateStartupImage(int startupImageId, CreateStartupImageRequest request, Response res) {
		try {
			StartupImage startupImage = startupImageRepository.getStartupImage(startupImageId);
			BeanUtils.copyProperties(request, startupImage);
			startupImageRepository.save(startupImage);
			String resp = "Update Startup Image ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Update Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> deleteStartupImage(int startupImageId, Response res) {
		try {
			startupImageRepository.deleteStartupImage(startupImageId);
			String resp = "Delete Startup Image ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Delete Startup Image has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Startup Image has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

}
