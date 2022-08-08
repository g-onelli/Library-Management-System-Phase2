package com.springboot.backend.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
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
import com.springboot.backend.dto.PatronEditDto;
import com.springboot.backend.model.Patron;
import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.PatronRepository;

@RestController
public class PatronController {
	@Autowired //<- Spring will wire it to PatronsRepository Interface. 
	private PatronRepository patronRepository; 
	@Autowired
	private PasswordEncoder passwordEncoder;
	//Add a new patron
	@PostMapping("/signup")
	public void postPatrons(@RequestBody PatronDto patronDto) {
		String str = new String(Base64.getDecoder().decode(patronDto.getEncodedCredentials()));
		String username = str.split("@%")[0];
		String password = str.split("@%")[1];
		Patron patron = new Patron();
		UserInfo user = new UserInfo();
		user.setRole("PATRON");
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		patron.setName(patronDto.getName());
		patron.setCardexpirationdate(patronDto.getCardexpirationdate());
		patron.setBalance(0.0);
		patron.setCardexpirationdate(LocalDate.now().plusYears(1));
		patron.setUserinfo(user);
		patronRepository.save(patron);
	}
	//Get all patrons
	@GetMapping("/patrons")
	public List<PatronDto> getAllPatrons(@RequestParam(name ="page") Integer page,
			@RequestParam(name="size") Integer size) {
		if(page <0) {
			page = 0;
		}
		Pageable pageable=PageRequest.of(page, size);
		List<Patron> pagelist = patronRepository.findAll(pageable).getContent();
		List<PatronDto> listDto = new ArrayList<>();
		Integer totalPages = patronRepository.findAll(pageable).getTotalPages();;
		pagelist.stream().forEach(p->{
			PatronDto dto = new PatronDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setCardexpirationdate(p.getCardexpirationdate());
			dto.setBalance(p.getBalance());
			dto.setUid(p.getUserinfo().getId());
			dto.setUsername(p.getUserinfo().getUsername());
			dto.setRole(p.getUserinfo().getRole());
			dto.setTotalpages(totalPages);
			listDto.add(dto);
		});
		return listDto; 
	}
	//Remove specific patron(DELETE)
	@DeleteMapping("/patrons/{id}")
	public void deletePatrons(@PathVariable("id") Integer id) {
		
		patronRepository.deleteById(id);
	}
	@GetMapping("/patron/{id}")
	public PatronEditDto getPatronById(@PathVariable("id") Integer id) {
		Optional<Patron> optional =  patronRepository.findById(id);
		if(optional.isPresent()) {
			PatronEditDto dto = new PatronEditDto(optional.get().getId(), optional.get().getName(), optional.get().getCardexpirationdate(), optional.get().getBalance());
			return dto;
		}
		throw new RuntimeException("ID is invalid");
		
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
	@PutMapping("/patrons")
	public void updatePatrons(@RequestBody PatronEditDto dto) {
		Optional<Patron> optional = patronRepository.findById(dto.getId());
		if(optional.isPresent()) {	
			patronRepository.updatePatron(optional.get().getId(), dto.getName(), dto.getCardexpirationdate(), dto.getBalance());
		}
		else
			throw new RuntimeException("ID is invalid");
	}
	//update patron balance (PUT)
	@PutMapping("/patrons/balance/{id}")
	public void updatePatronBalance(@PathVariable("id") Integer id, @RequestBody Patron newPatronBalance) {
		Optional<Patron> optional = patronRepository.findById(id);
		if(optional.isPresent()) {	
			Patron existingPatrons = optional.get();
			existingPatrons.setBalance(newPatronBalance.getBalance());
			patronRepository.save(existingPatrons);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
	//Renew library card (PUT)
	@PutMapping("/patrons/card/{id}")
	public void updatePatronCard(@PathVariable("id") Integer id, @RequestBody Patron newPatronCard) {
		Optional<Patron> optional = patronRepository.findById(id);
		if(optional.isPresent()) {	
			Patron existingPatrons = optional.get();
			existingPatrons.setCardexpirationdate(newPatronCard.getCardexpirationdate());
			patronRepository.save(existingPatrons);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
}
