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

import com.springboot.backend.model.Rooms;
import com.springboot.backend.repository.RoomsRepository;

@RestController
public class RoomsController {
	@Autowired
	private RoomsRepository roomsRepository;
	
	@PostMapping("/rooms")
	public void postRoom(@RequestBody Rooms rooms) {
		roomsRepository.save(rooms);
	}
	
	@GetMapping("/rooms")
	public List<Rooms> getAllRooms(){
		List<Rooms> rList = roomsRepository.findAll();
		return rList;
	}
	
	@GetMapping("/rooms/single/{rid}")
	public Rooms getSingleRoom(@PathVariable("rid") Integer rid) {
		Optional<Rooms> sRoom = roomsRepository.findById(rid);
		if(!sRoom.isPresent()) {
			throw new RuntimeException("This room number is not found in database.");
		}
		return sRoom.get();
	}
	
	@DeleteMapping("/rooms/{rid}")
	public void deleteRoomById(@PathVariable("rid") Integer rid) {
		roomsRepository.deleteById(rid);
	}
	
	@PutMapping("/rooms/{rid}")
	public Rooms updateRoomById(@PathVariable("rid") Integer rid, @RequestBody Rooms uRoomValue){
		Optional<Rooms> optRoom = roomsRepository.findById(rid);
		if(!optRoom.isPresent()) {
			throw new RuntimeException("This room number is not found in database.");
		}
		Rooms oldRoom = optRoom.get();
		
		oldRoom.setCapacity(uRoomValue.getCapacity());
		oldRoom.setHasPresenterTools(uRoomValue.getHasPresenterTools());
		return roomsRepository.save(oldRoom);
	}
	

}
