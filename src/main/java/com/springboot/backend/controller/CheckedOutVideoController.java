package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Book;
import com.springboot.backend.model.CheckedOutBook;
import com.springboot.backend.model.CheckedOutVideo;
import com.springboot.backend.model.Patron;
import com.springboot.backend.model.Video;
import com.springboot.backend.repository.CheckedOutVideoRepository;
import com.springboot.backend.repository.PatronRepository;
import com.springboot.backend.repository.VideoRepository;


@RestController
public class CheckedOutVideoController {
	
	
	@Autowired
	private CheckedOutVideoRepository checkedOutVideoRepository;
	
	@Autowired
	private PatronRepository patronRepository;
	
	@Autowired
	private VideoRepository videoRepository;
	
	@PostMapping("/checkedoutvideo/{pid}/{vid}")
	public CheckedOutVideo postCheckedOutVideo(@RequestBody CheckedOutVideo checkedOutVideo,
			@PathVariable("pid") Long pid,
			@PathVariable("vid") Long vid) {
		//go to repo and fetch Patron by id
		Optional<Patron> optional = patronRepository.findById(pid);
		if(optional.isEmpty())
			throw new RuntimeException("Patron ID is invalid");
		Patron patron = optional.get();
		
		//go to repo and fetch book by id
		Optional<Video> optionalV = videoRepository.findById(vid);
		if(optionalV.isEmpty())
			throw new RuntimeException("Book ID is invalid");
		Video video = optionalV.get();
		
		//attach Patron and Book to product
		checkedOutVideo.setPatron(patron);
		checkedOutVideo.setVideo(video);
		
		//save checkedoutbook in the DB
		
		return checkedOutVideo.save(checkedOutVideo);
		
		
	}
	
	@GetMapping("/checkedoutvideo")
	public List<CheckedOutVideo> getAllCheckedOutVideos(){
		return checkedOutVideoRepository.findAll();
	
	}

	
	@GetMapping("/checkedoutvideo/patron/{pid}")
	public List<CheckedOutVideo> getCheckedOutVideosByPatronId(@PathVariable("pid") Long pid) {
		return checkedOutVideoRepository.getCheckedOutVideosByPatronId(pid);
			
	}
	
	@GetMapping("/checkedoutvideo/video/{vid}")
	public List<CheckedOutVideo> getCheckedOutVideosByVideoId(@PathVariable("vid") Long vid) {
		return checkedOutVideoRepository.getCheckedOutVideosByVideoId(vid);
			
	}
	
	@DeleteMapping("/checkedoutvideo/{pid}")
	public void deleteCheckedOutVideoByPatronId(@PathVariable("pid") Long pid) {
		checkedOutVideoRepository.deleteCheckedOutVideoByPatronId(pid);
		
	}
	
	@DeleteMapping("/checkedoutvideo/{vid}")
	public void deleteCheckedOutVideosByVideoId(@PathVariable("vid") Long vid) {
		checkedOutVideoRepository.deleteCheckedOutVideosByVideoId(vid);
	}

}
