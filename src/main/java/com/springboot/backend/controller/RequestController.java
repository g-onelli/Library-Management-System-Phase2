package com.springboot.backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.RequestDto;
import com.springboot.backend.model.Book;
import com.springboot.backend.model.Patron;
import com.springboot.backend.model.Request;
import com.springboot.backend.repository.BookRepository;
import com.springboot.backend.repository.PatronRepository;
import com.springboot.backend.repository.RequestRepository;

@RestController
public class RequestController {
	@Autowired 
	private RequestRepository requestRepository; 
	@Autowired
	private PatronRepository patronRepository;
	@Autowired
	private BookRepository bookRepository;
	
	//Insert new Request and attach patron ID - Submit book requests (POST)
	@PostMapping("/requests/patrons/{pid}")
	public Request postRequests(@RequestBody Request request, @PathVariable("pid") Integer pid) {
		
		Optional<Patron> optional = patronRepository.findById(pid);
		if(!optional.isPresent())
			throw new RuntimeException("Patron ID is invalid");
		RequestDto dto = new RequestDto();
		request.setSubmissiondate(LocalDate.now());
		Patron patron = optional.get();
		
		request.setPatron(patron);
		return requestRepository.save(request);
		
	}
	
	//Return all requests View book requests (GET)
	@GetMapping("/requests")
	public List<RequestDto> getAllRequests(@RequestParam(name ="page") Integer page,
			@RequestParam(name="size") Integer size) {
		if(page <0) {
			page = 0;
		}
		Pageable pageable=PageRequest.of(page, size);
		List<Request> list = requestRepository.findAll(pageable).getContent();
		List<RequestDto> listDto = new ArrayList<>(); 
		Integer tPages = patronRepository.findAll(pageable).getTotalPages();
		list.stream().forEach(r->{
			RequestDto dto = new RequestDto();
			dto.setId(r.getId());
			dto.setDescription(r.getDescription());
			dto.setSubmissiondate(r.getSubmissiondate());
			dto.setTitle(r.getTitle());
			dto.setAuthor(r.getAuthor());
			dto.setPid(r.getPatron().getId());
			dto.setPname(r.getPatron().getName());
			dto.setTotalpages(tPages);
			listDto.add(dto);
		});
		return listDto; 
	}
	
	//Return a request based on ID (probably not needed)
	@GetMapping("/requests/{id}") 
	public Request getSingleRequestById(@PathVariable("id") Integer id) {
		Optional<Request> optional =  requestRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}
	//Complete book requests (DELETE)
	@DeleteMapping("/requests/{id}")
	public void deleteRequests(@PathVariable("id") Integer id) {
		
		requestRepository.deleteById(id);
	}
	//Complete book requests (POST)
		@PostMapping("/requests/{id}")
		public void completeRequests(@RequestBody Book book,@PathVariable("id") Integer id) {
			Optional<Request> optional = requestRepository.findByRid(id);
			if(!optional.isPresent())
				throw new RuntimeException("Request ID is invalid");
			
			Request request = optional.get();
			book.setAuthor(request.getAuthor());
			book.setTitle(request.getTitle());
			book.setCallNumber(bookRepository.nextCallNumber()+1);
			book.setGenre(book.getGenre());
			book.setPublisher(book.getPublisher());
			requestRepository.deleteById(id);
			bookRepository.save(book);
		}
}
