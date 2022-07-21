package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Book;
import com.springboot.backend.repository.BookRepository;

@RestController
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
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Book ID is invalid");
		return optional.get();
			
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBookById(@PathVariable("id") Integer id) {
		bookRepository.deleteById(id);
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable("id") Integer id,
			@RequestBody Book newBook) {
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Book ID is invalid");
		Book existingBook = optional.get();
		existingBook.setTitle(newBook.getTitle());
		existingBook.setAuthor(newBook.getAuthor());
		existingBook.setPublisher(newBook.getPublisher());
		existingBook.setCallNumber(newBook.getCallNumber());
		existingBook.setGenre(newBook.getGenre());
		return bookRepository.save(existingBook);
		
	}
	
	

}
