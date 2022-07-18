package com.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.backend.model.Book;
import com.springboot.backend.repository.BookRepository;

public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/book")
	public void postBook(@RequestBody Book book) {
		bookRepository.save(book);
	}
	
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		List<Book> list = bookRepository.findAll();
		return list;
	}

}
