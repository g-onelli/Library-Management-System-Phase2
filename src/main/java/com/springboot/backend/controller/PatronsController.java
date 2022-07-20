package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Patrons;
import com.springboot.backend.repository.PatronsRepository;

@RestController
public class PatronsController {
	@Autowired //<- Spring will wire it to PatronsRepository Interface. 
	private PatronsRepository patronsRepository; 
	//Add a new patron
	@PostMapping("/patrons")
	public void postPatrons(@RequestBody Patrons patrons) {
		patronsRepository.save(patrons);
	}
	//Get all patrons
	@GetMapping("/patrons")
	public List<Patrons> getAllPatrons() {
		List<Patrons> list = patronsRepository.findAll();
		return list; 
	}
	
	//Get a specific patron based on Id
	@GetMapping("/patrons/{id}") //patrons/4
	public Patrons getSinglePatronById(@PathVariable("id") Long id) {
		Optional<Patrons> optional =  patronsRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
		  
	}
	//Update a specific patron based on Id
	@PutMapping("/patrons/{id}")
	public Patrons updatePatrons(@PathVariable("id") Long id, @RequestBody Patrons newPatrons) {
		Optional<Patrons> optional = patronsRepository.findById(id);
		if(optional.isPresent()) {	
			Patrons existingPatrons = optional.get();
			existingPatrons.setName(newPatrons.getName());
			existingPatrons.setCardexpirationdate(newPatrons.getCardexpirationdate());
			existingPatrons.setBalance(newPatrons.getBalance());
			existingPatrons.setPassword(newPatrons.getPassword());
			return patronsRepository.save(existingPatrons);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
}
