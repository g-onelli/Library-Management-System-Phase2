package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Requests;
import com.springboot.backend.repository.RequestsRepository;

@RestController
public class RequestsController {
	@Autowired //<- Spring will wire it to requestsRepository interface. 
	private RequestsRepository requestsRepository; 
	
	@GetMapping("/requests")
	public List<Requests> getAllRequests() {
		List<Requests> list = requestsRepository.findAll();
		return list; 
	}
	
	@GetMapping("/requests/{id}") //requests/single/4
	public Requests getSingleRequestById(@PathVariable("id") Integer id) {
		Optional<Requests> optional =  requestsRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
		  
	}
}
