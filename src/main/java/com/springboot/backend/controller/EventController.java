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

import com.springboot.backend.model.Event;
import com.springboot.backend.model.Librarian;
import com.springboot.backend.repository.EventRepository;
import com.springboot.backend.repository.LibrarianRepository;

@RestController
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private LibrarianRepository librarianRepository;
	
	//Insert a new event with the attached librarian ID
	@PostMapping("/event/{lid}")
	public Event postEvent(@RequestBody Event event, @PathVariable("lid") Integer lid) {
		Optional<Librarian> optional = librarianRepository.findById(lid);
		if(!optional.isPresent()) {
			throw new RuntimeException("Librarian ID is invalid");
		}
		Librarian librarian = optional.get();
		event.setLibrarian(librarian);
		return eventRepository.save(event);
	}
	
	//Return all the events
	@GetMapping("/event")
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}
	
	//Return the even by ID (probably extra)
	@GetMapping("/event/{id}")
	public Event getEventByID(@PathVariable("id") Integer id) {
		Optional<Event> optional = eventRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("Event ID is invalid");
	}
	
	
	//Delete an event by ID
	@DeleteMapping("/event/{id}")
	public void deleteEventById(@PathVariable("id") Integer id) {
		eventRepository.deleteById(id);
	}
	
	//Edit an event
	@PutMapping("/event/{id}")
	public Event updateEvent(@PathVariable("id") Integer id,
			@RequestBody Event newEvent) {
		Optional<Event> optional = eventRepository.findById(id);
		if(optional.isPresent()) {
			Event existingEvent = optional.get();
			existingEvent.setTitle(newEvent.getTitle());
			existingEvent.setDescription(newEvent.getDescription());
			existingEvent.setDate(newEvent.getDate());
			return eventRepository.save(existingEvent);
		}
		else {
			throw new RuntimeException("Event ID is invalid");
		}
	}
}
