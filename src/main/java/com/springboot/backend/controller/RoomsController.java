package com.springboot.backend.controller;

import java.time.LocalDate;
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

import com.springboot.backend.model.Room;
import com.springboot.backend.repository.RoomsRepository;

@RestController
public class RoomsController {
	@Autowired
	private RoomsRepository roomsRepository;
	
	@PostMapping("/rooms")
	public void postRoom(@RequestBody Room rooms) {
		roomsRepository.save(rooms);
	}
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms(){
		List<Room> rList = roomsRepository.findAll();
		return rList;
	}
	
	@GetMapping("/rooms/{strYr}/{strMon}/{strDay}")
	public List<Room> getAllOpenRooms(@PathVariable("strYr") String strYr,@PathVariable("strMon") String strMon,@PathVariable("strDay") String strDay){
		String strDate = strYr+"-"+strMon+"-"+strDay;
		List<Integer> rNums = roomsRepository.getRoomNumbers(LocalDate.parse(strDate));
		List<Room> rList = roomsRepository.showOpenRooms(rNums);
		return rList;
	}
	
	@GetMapping("/rooms/single/{rid}")
	public Room getSingleRoom(@PathVariable("rid") Integer rid) {
		Optional<Room> sRoom = Optional.of(roomsRepository.showRoomByNum(rid));
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
	public Room updateRoomById(@PathVariable("rid") Integer rid, @RequestBody Room uRoomValue){
		Optional<Room> optRoom = Optional.of(roomsRepository.showRoomByNum(rid));
		if(!optRoom.isPresent()) {
			throw new RuntimeException("This room number is not found in database.");
		}
		Room oldRoom = optRoom.get();
		
		oldRoom.setCapacity(uRoomValue.getCapacity());
		oldRoom.setHasPresenterTools(uRoomValue.getHasPresenterTools());
		return roomsRepository.save(oldRoom);
	}
	

}
