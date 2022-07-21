package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Librarian;
import com.springboot.backend.repository.LibrarianRepository;


@RestController
public class LibrarianController {
	@Autowired 
	private LibrarianRepository librarianRepository; 
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
	
}
