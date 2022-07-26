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
import com.springboot.backend.model.Patron;
import com.springboot.backend.repository.PatronRepository;

@RestController
public class PatronController {
	@Autowired //<- Spring will wire it to PatronsRepository Interface. 
	private PatronRepository patronRepository; 
	//Add a new patron
	@PostMapping("/patrons")
	public void postPatrons(@RequestBody Patron patron) {
		patronRepository.save(patron);
	}
	//Get all patrons
	@GetMapping("/patrons")
	public List<Patron> getAllPatrons() {
		List<Patron> list = patronRepository.findAll();
		return list; 
	}
	
	//Get a specific patron based on Id
	@GetMapping("/patrons/{id}") //patrons/4
	public Patron getSinglePatronById(@PathVariable("id") Integer id) {
		Optional<Patron> optional =  patronRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
		  
	}
	//Update a specific patron based on Id
	@PutMapping("/patrons/{id}")
	public Patron updatePatrons(@PathVariable("id") Integer id, @RequestBody Patron newPatrons) {
		Optional<Patron> optional = patronRepository.findById(id);
		if(optional.isPresent()) {	
			Patron existingPatrons = optional.get();
			existingPatrons.setName(newPatrons.getName());
			existingPatrons.setCardexpirationdate(newPatrons.getCardexpirationdate());
			existingPatrons.setBalance(newPatrons.getBalance());
			return patronRepository.save(existingPatrons);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
}
