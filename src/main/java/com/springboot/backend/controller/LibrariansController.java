package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Librarians;
import com.springboot.backend.repository.LibrariansRepository;


@RestController
public class LibrariansController {
	@Autowired 
	private LibrariansRepository librariansRepository; 
	@GetMapping("/librarians")
	public List<Librarians> getAllLibrarians() {
		List<Librarians> list = librariansRepository.findAll();
		return list; 
	}
	
	//Get a specific patron based on Id
	@GetMapping("/librarians/{id}") //librarians/4
	public Librarians getSinglePatronById(@PathVariable("id") Integer id) {
		Optional<Librarians> optional =  librariansRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
		  
	}
	
}
