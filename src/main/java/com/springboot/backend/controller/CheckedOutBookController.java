package com.springboot.backend.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.CheckedOutBookDto;
import com.springboot.backend.model.Book;
import com.springboot.backend.model.CheckedOutBook;
import com.springboot.backend.model.Patron;
import com.springboot.backend.repository.BookRepository;
import com.springboot.backend.repository.CheckedOutBookRepository;
import com.springboot.backend.repository.PatronRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckedOutBookController {

	
	@Autowired
	private CheckedOutBookRepository checkedOutBookRepository;
	
	@Autowired
	private PatronRepository patronRepository;
	
	@Autowired 
	private BookRepository bookRepository;
	
	@PostMapping("/checkoutbook/{pid}/{bid}")
	public CheckedOutBook checkOutBook(@PathVariable("pid") Integer pid, @PathVariable("bid") Integer bid) {
		//go to repo and fetch Patron by id
		CheckedOutBook checkedOutBook = new CheckedOutBook();
		Optional<Patron> optional = patronRepository.findById(pid);
		if(optional.isEmpty())
			throw new RuntimeException("Patron ID is invalid");
		Patron patron = optional.get();	
		//go to repo and fetch book by id
		Optional<Book> optionalB = bookRepository.findById(bid);
		if(optionalB.isEmpty())
			throw new RuntimeException("Book ID is invalid");
		Book book = optionalB.get();
		
		//attach Patron and Book to product
		checkedOutBook.setPatron(patron);
		checkedOutBook.setBook(book);
		checkedOutBook.setDueDate(LocalDate.now().plusWeeks(2));
		
		//save checkedoutbook in the DB
		
		return checkedOutBookRepository.save(checkedOutBook);
		
		
	}
	
	@GetMapping("/checkedoutbook")
	public List<CheckedOutBookDto> getAllCheckedOutBooks(){
		List<CheckedOutBook> list = checkedOutBookRepository.findAll();
		List<CheckedOutBookDto> listDto = new ArrayList<>();
		
		list.stream().forEach(cb -> {
			CheckedOutBookDto dto = new CheckedOutBookDto(cb.getId(),
					cb.getPatron().getId(),
					cb.getPatron().getName(),
					cb.getPatron().getCardexpirationdate(),
					cb.getPatron().getBalance(),
					cb.getBook().getId(),
					cb.getBook().getTitle(),
					cb.getBook().getAuthor(),
					cb.getBook().getPublisher(),
					cb.getBook().getCallNumber(),
					cb.getBook().getGenre(),
					LocalDate.now().plusWeeks(2));
			
			listDto.add(dto);
		});
		
		return listDto;
		
	}
	
	@GetMapping("/checkedoutbook/patron/{pid}")
	public List<CheckedOutBookDto> getCheckedOutBooksByPatronId(@PathVariable("pid") Integer pid) {
		List<CheckedOutBook> list  = checkedOutBookRepository.getCheckedOutBooksByPatronId(pid);
		
		List<CheckedOutBookDto> listDto = new ArrayList<>();
		
		list.stream().forEach(cb -> {
			CheckedOutBookDto dto = new CheckedOutBookDto(cb.getId(),
					cb.getPatron().getId(),
					cb.getPatron().getName(),
					cb.getPatron().getCardexpirationdate(),
					cb.getPatron().getBalance(),
					cb.getBook().getId(),
					cb.getBook().getTitle(),
					cb.getBook().getAuthor(),
					cb.getBook().getPublisher(),
					cb.getBook().getCallNumber(),
					cb.getBook().getGenre(),
					LocalDate.now().plusWeeks(2));
			
			listDto.add(dto);
		});
		
		return listDto;
			
	}
	
	@GetMapping("/checkedoutbook/book/{bid}")
	public List<CheckedOutBookDto> getCheckedOutBooksByBookId(@PathVariable("bid") Integer bid) {
		List<CheckedOutBook> list = checkedOutBookRepository.getCheckedOutBooksByBookId(bid);
		
		List<CheckedOutBookDto> listDto = new ArrayList<>();
		
		list.stream().forEach(cb -> {
			CheckedOutBookDto dto = new CheckedOutBookDto(cb.getId(),
					cb.getPatron().getId(),
					cb.getPatron().getName(),
					cb.getPatron().getCardexpirationdate(),
					cb.getPatron().getBalance(),
					cb.getBook().getId(),
					cb.getBook().getTitle(),
					cb.getBook().getAuthor(),
					cb.getBook().getPublisher(),
					cb.getBook().getCallNumber(),
					cb.getBook().getGenre(),
					LocalDate.now().plusWeeks(2));
			
			listDto.add(dto);
		});
		
		return listDto;
			
	}
	
	@DeleteMapping("/checkedoutbook/{id}")
	public void deleteCheckedOutBookById(@PathVariable("id") Integer id) {
		checkedOutBookRepository.deleteById(id);
	}
	
}
