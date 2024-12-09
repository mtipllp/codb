package com.mtipservice.APIService.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mtipservice.APIService.entity.CreateVideoRequest;
import com.mtipservice.APIService.entity.Errors;
import com.mtipservice.APIService.entity.Response;
import com.mtipservice.APIService.model.Video;
import com.mtipservice.APIService.model.VideoPK;
import com.mtipservice.APIService.repository.VideoRepository;

@Service
public class VideoService {
	@Autowired
	VideoRepository videoRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);
	
	public ResponseEntity<Response> getVideo(String language, String type, Response res) {
		try {
			Video supp = videoRepository.getVideo(language, type);
			res.setResponse(supp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Video has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> getAllVideos(Response res) {
		try {
			List<Video> Videos = videoRepository.findAll();
			res.setResponse(Videos);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Searching for Videos has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Searching for Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

	public ResponseEntity<Response> createVideo(CreateVideoRequest request, Response res) {
		try {
			Video video = new Video();
			VideoPK videoPk = new VideoPK();
			videoPk.setLanguage(request.getLanguage());
			videoPk.setType(request.getType());
			video.setId(videoPk);
			video.setAudioLink(request.getAudioLink());
			video.setComments(request.getComments());
			video.setDishId(request.getDishId());
			video.setLink(request.getLink());
			videoRepository.save(video);
			String resp = "Create Video ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Create Video has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Create Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}


	public ResponseEntity<Response> updateVideo(String language, String type, CreateVideoRequest request, Response res) {
		try {
			Video video = videoRepository.getVideo(language, type);
			BeanUtils.copyProperties(request, video);
			video.setAudioLink(request.getAudioLink());
			video.setComments(request.getComments());
			video.setDishId(request.getDishId());
			video.setLink(request.getLink());
			videoRepository.save(video);
			String resp = "Update Video ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Update Video has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Update Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}
	
	public ResponseEntity<Response> deleteVideo(String language, String type, Response res) {
		try {
			Video video = videoRepository.getVideo(language, type);
			videoRepository.delete(video);
			String resp = "Delete Video ended successfully";
			res.setResponse(resp);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}catch (Exception e) {
			LOGGER.error("Delete Video has errored OUT with error-:" + e.getMessage());
			Errors err = new Errors();
			err.setCode("ERR001");
			err.setMessage("Delete Video has errored OUT with error-:" + e.getMessage());
			err.setSource(this.getClass().getName());
			res.setErr(err);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);

		}
	}

}
