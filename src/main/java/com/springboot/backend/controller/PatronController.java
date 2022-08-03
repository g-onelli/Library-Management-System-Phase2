package com.springboot.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.backend.dto.PatronDto;
import com.springboot.backend.model.Patron;
import com.springboot.backend.repository.PatronRepository;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class PatronController {
	@Autowired //<- Spring will wire it to PatronsRepository Interface. 
	private PatronRepository patronRepository; 
	@Autowired
	private PasswordEncoder passwordEncoder;
	//Add a new patron
	@PostMapping("/patrons")
	public void postPatrons(@RequestBody Patron patron) {
		String password = patron.getUserinfo().getPassword();
		password = passwordEncoder.encode(password);
		patron.getUserinfo().setPassword(password);
		patronRepository.save(patron);
	}
	//Get all patrons
	@GetMapping("/patrons")
	public List<PatronDto> getAllPatrons(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {
		if(page <0) {
			page = 0;
		}
		Pageable pageable=PageRequest.of(page, size);
		Page<Patron> pagelist = patronRepository.findAll(pageable);
		List<PatronDto> listDto = new ArrayList<>();
		pagelist.stream().forEach(p->{
			PatronDto dto = new PatronDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setCardexpirationdate(p.getCardexpirationdate());
			dto.setBalance(p.getBalance());
			dto.setUid(p.getUserinfo().getId());
			dto.setUsername(p.getUserinfo().getUsername());
			dto.setRole(p.getUserinfo().getRole());
			listDto.add(dto);
		});
		return listDto; 
	}
	//Remove specific patron(DELETE)
	@DeleteMapping("/patrons/{id}")
	public void deletePatrons(@PathVariable("id") Integer id) {
		
		patronRepository.deleteById(id);
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
			//existingPatrons.getUserinfo().setUsername(newPatrons.getUserinfo().getUsername());
			return patronRepository.save(existingPatrons);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
	//update patron balance (PUT)
	@PutMapping("/patrons/balance/{id}")
	public Patron updatePatronBalance(@PathVariable("id") Integer id, @RequestBody Patron newPatronBalance) {
		Optional<Patron> optional = patronRepository.findById(id);
		if(optional.isPresent()) {	
			Patron existingPatrons = optional.get();
			existingPatrons.setBalance(newPatronBalance.getBalance());
			return patronRepository.save(existingPatrons);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
	//Renew library card (PUT)
	@PutMapping("/patrons/card/{id}")
	public Patron updatePatronCard(@PathVariable("id") Integer id, @RequestBody Patron newPatronCard) {
		Optional<Patron> optional = patronRepository.findById(id);
		if(optional.isPresent()) {	
			Patron existingPatrons = optional.get();
			existingPatrons.setCardexpirationdate(newPatronCard.getCardexpirationdate());
			return patronRepository.save(existingPatrons);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
}
