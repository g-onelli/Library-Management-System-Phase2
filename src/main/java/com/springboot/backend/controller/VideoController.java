package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.backend.model.Video;
import com.springboot.backend.repository.VideoRepository;

@RestController
public class VideoController {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@PostMapping("/video")
	public void postVideo(@RequestBody Video video) {
		videoRepository.save(video);
	}
	
	@GetMapping("/video")
	public List<Video> getAllVideos(){
		List<Video> list = videoRepository.findAll();
		return list;
	}
	
	@GetMapping("/video/{id}")
	public Video getVideoById(@PathVariable("id") Long id) {
		Optional<Video> optional = videoRepository.findById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Video ID is invalid");
		return optional.get();
			
	}
	
	@DeleteMapping("/video/{id}")
	public void deleteVideoById(@PathVariable("id") Long id) {
		videoRepository.deleteById(id);
	}
	
	@PutMapping("/video/{id}")
	public Video updateVideo(@PathVariable("id") Long id,
			@RequestBody Video newVideo) {
		Optional<Video> optional = videoRepository.findById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Video ID is invalid");
		Video existingVideo = optional.get();
		existingVideo.setTitle(newVideo.getTitle());
		existingVideo.setDirector(newVideo.getDirector());
		existingVideo.setReleaseDate(newVideo.getReleaseDate());
		existingVideo.setCallNumber(newVideo.getCallNumber());
		existingVideo.setGenre(existingVideo.getGenre());
		return videoRepository.save(existingVideo);
		
	}

}
