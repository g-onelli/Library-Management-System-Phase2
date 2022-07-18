package com.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/category")
	public List<Video> getAllVideos(){
		List<Video> list = videoRepository.findAll();
		return list;
	}

}
