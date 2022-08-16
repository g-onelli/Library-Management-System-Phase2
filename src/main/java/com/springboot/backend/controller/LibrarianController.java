package com.springboot.backend.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.LibrarianIdDto;
import com.springboot.backend.model.Librarian;
import com.springboot.backend.repository.LibrarianRepository;


@RestController
public class LibrarianController {
	@Autowired 
	private LibrarianRepository librarianRepository; 
	@Autowired
	private PasswordEncoder passwordEncoder;
	@GetMapping("/librarians")
	public List<Librarian> getAllLibrarians() {
		List<Librarian> list = librarianRepository.findAll();
		return list; 
	}
	
	//Get a specific patron based on Id
	@GetMapping("/librarians/{id}") //librarians/4
	public Librarian getSinglePatronById(@PathVariable("id") Integer id) {
		Optional<Librarian> optional =  librarianRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
		  
	}
	//Add a new librarian
		@PostMapping("/librarians")
		public void postLibrarians(@RequestBody Librarian librarian) {
			String password = librarian.getUserinfo().getPassword();
			password = passwordEncoder.encode(password);
			librarian.getUserinfo().setPassword(password);
			librarianRepository.save(librarian);
		}
		@GetMapping("/librarianId")
		public Librarian login(Principal principal) {
			String username = principal.getName();
			Librarian info = librarianRepository.getByUsername(username);
			
			LibrarianIdDto dto = new LibrarianIdDto();
			//dto.setId(info.getId());
			return info;			
		}
}
