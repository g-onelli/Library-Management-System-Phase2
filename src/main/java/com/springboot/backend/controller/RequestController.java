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

import com.springboot.backend.model.Patron;
import com.springboot.backend.model.Request;
import com.springboot.backend.repository.PatronRepository;
import com.springboot.backend.repository.RequestRepository;

@RestController
public class RequestController {
	@Autowired 
	private RequestRepository requestRepository; 
	@Autowired
	private PatronRepository patronRepository;
	
	//Insert new Request and attach patron ID
	@PostMapping("/requests/patrons/{pid}")
	public Request postRequests(@RequestBody Request request, @PathVariable("pid") Integer pid) {
		
		Optional<Patron> optional = patronRepository.findById(pid);
		if(!optional.isPresent())
			throw new RuntimeException("Patron ID is invalid");
		
		Patron patron = optional.get();
		
		request.setPatron(patron);
		
		return requestRepository.save(request);
		
	}
	
	//Return all requests
	@GetMapping("/requests")
	public List<Request> getAllRequests() {
		List<Request> list = requestRepository.findAll();
		return list; 
	}
	
	//Return a request based on ID (probably not needed)
	@GetMapping("/requests/{id}") 
	public Request getSingleRequestById(@PathVariable("id") Integer id) {
		Optional<Request> optional =  requestRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}
	@DeleteMapping("/requests/{id}")
	public void deleteRequests(@PathVariable("id") Integer id) {
		requestRepository.deleteById(id);
	}
	
}
