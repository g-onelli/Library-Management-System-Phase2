package com.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.CheckedOutVideo;
import com.springboot.backend.repository.CheckedOutVideoRepository;


@RestController
public class CheckedOutVideoController {
	
	
	@Autowired
	private CheckedOutVideoRepository checkedOutVideoRepository;
	
	@PostMapping("/checkedoutvideo")
	public void postCheckedOutVideo(@RequestBody CheckedOutVideo checkedOutVideo) {
		checkedOutVideoRepository.save(checkedOutVideo);
	}
	
	@GetMapping("/category")
	public List<CheckedOutVideo> getAllCheckedOutVideos(){
		List<CheckedOutVideo> list = checkedOutVideoRepository.findAll();
		return list;
	}

}
