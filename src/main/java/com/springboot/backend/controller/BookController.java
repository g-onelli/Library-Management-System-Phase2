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
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.BookDto;
import com.springboot.backend.model.Book;
import com.springboot.backend.repository.BookRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/book")
	public void postBook(@RequestBody Book book) {
		bookRepository.save(book);
	}
	
	@GetMapping("/book")
	public List<BookDto> getAllBooks(){
		List<Book> list = bookRepository.findAll();
		List<BookDto> listDto = new ArrayList<>();
		
		list.stream().forEach(b ->{
			BookDto dto = new BookDto(b.getId(),
					b.getTitle(),
					b.getAuthor(),
					b.getPublisher(),
					b.getCallNumber(),
					b.getGenre());
			listDto.add(dto);
			
		});
		return listDto;
	}
	
	@GetMapping("/book/{id}")
	public BookDto getBookById(@PathVariable("id") Integer id) {
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isEmpty())
			throw new RuntimeException("Book ID is invalid");
		
		return new BookDto(optional.get().getId(),
				optional.get().getTitle(),
				optional.get().getAuthor(),
				optional.get().getPublisher(),
				optional.get().getCallNumber(),
				optional.get().getGenre());
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
	
	@GetMapping("/book/available")
	public List<BookDto> getAvailableBooks(){
		List<Book> list = bookRepository.getAvailableBooks();
		List<BookDto> listDto = new ArrayList<>();
		
		list.stream().forEach(b ->{
			BookDto dto = new BookDto(b.getId(),
					b.getTitle(),
					b.getAuthor(),
					b.getPublisher(),
					b.getCallNumber(),
					b.getGenre());
			listDto.add(dto);
			
		});
		return listDto;
	}
	
	

}
