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

import com.springboot.backend.model.Patrons;
import com.springboot.backend.model.Requests;
import com.springboot.backend.repository.PatronsRepository;
import com.springboot.backend.repository.RequestsRepository;

@RestController
public class RequestsController {
	@Autowired 
	private RequestsRepository requestsRepository; 
	@Autowired
	private PatronsRepository patronsRepository;
	
	//Insert new Request and attach patron ID
	@PostMapping("/requests/patrons/{pid}")
	public Requests postRequests(@RequestBody Requests request, @PathVariable("pid") Integer pid) {
		
		Optional<Patrons> optional = patronsRepository.findById(pid);
		if(!optional.isPresent())
			throw new RuntimeException("Patron ID is invalid");
		
		Patrons patrons = optional.get();
		
		request.setPatron(patrons);
		
		return requestsRepository.save(request);
		
	}
	
	//Return all requests
	@GetMapping("/requests")
	public List<Requests> getAllRequests() {
		List<Requests> list = requestsRepository.findAll();
		return list; 
	}
	
	//Return a request based on ID (probably not needed)
	@GetMapping("/requests/{id}") 
	public Requests getSingleRequestById(@PathVariable("id") Integer id) {
		Optional<Requests> optional =  requestsRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}
	@DeleteMapping("/requests/{id}")
	public void deleteRequests(@PathVariable("id") Integer id) {
		requestsRepository.deleteById(id);
	}
	
}
