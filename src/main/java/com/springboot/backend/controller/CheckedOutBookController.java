package com.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.CheckedOutBook;
import com.springboot.backend.repository.CheckedOutBookRepository;

@RestController
public class CheckedOutBookController {

	
	@Autowired
	private CheckedOutBookRepository checkedOutBookRepository;
	
	@PostMapping("/checkedoutbook")
	public void postCheckedOutBook(@RequestBody CheckedOutBook checkedOutBook) {
		checkedOutBookRepository.save(checkedOutBook);
	}
	
	@GetMapping("/checkedoutbook")
	public List<CheckedOutBook> getAllCategories(){
		List<CheckedOutBook> list = checkedOutBookRepository.findAll();
		return list;
	}
}
