package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Patrons;
import com.springboot.backend.repository.PatronsRepository;

@RestController
public class PatronsController {
	@Autowired //<- Spring will wire it to PatronsRepository interface. 
	private PatronsRepository patronsRepository; 
	
	@GetMapping("/patrons")
	public List<Patrons> getAllPatrons() {
		List<Patrons> list = patronsRepository.findAll();
		return list; 
	}
	
	@GetMapping("/patrons/{id}") //patrons/single/4
	public Patrons getSinglePatronById(@PathVariable("id") Integer id) {
		Optional<Patrons> optional =  patronsRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
		  
	}
}
