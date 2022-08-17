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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.RoomDto;
import com.springboot.backend.model.Room;
import com.springboot.backend.repository.RoomsRepository;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
//@CrossOrigin(origins = "http://localhost:4200")
public class RoomsController {
	@Autowired
	private RoomsRepository roomsRepository;
	
	@PostMapping("/rooms/add")
	public void postRoom(@RequestBody Room rooms) {
		roomsRepository.save(rooms);
	}
	
	@GetMapping("/rooms/open")
	public List<RoomDto> getAllOpenRooms(@RequestParam(name="strDate") String strDate, @RequestParam(name="strTime") String strTime){
		String[] splitTime = strTime.split(":");
		
		int hr = Integer.parseInt(splitTime[0])+1;
		int min = Integer.parseInt(splitTime[1]);
		if(min>=60) {
			hr+=1;
			min= min-60;
		}
		if(hr>=25) {
			hr-=25;
		}
		String strEndTime = Integer.toString(hr)+"."+Integer.toString(min);
		List<Integer> rNums = roomsRepository.getRoomNumbers(strDate, strTime,strEndTime);
		List<Room> rList = roomsRepository.showOpenRooms(rNums);
		List<RoomDto> dtoList = new ArrayList<>();
		rList.stream().forEach(r->{
			RoomDto dto = new RoomDto();
			dto.setRoomNumber(r.getRoomNumber());
			dto.setCapacity(r.getCapacity());
			dto.setHasPresenterTools(r.getHasPresenterTools());
			dtoList.add(dto);
		});
		return dtoList;
	}
	
	@GetMapping("/rooms/single/{rid}")
	public RoomDto getSingleRoom(@PathVariable("rid") Integer rid) {
		Optional<Room> sRoom = Optional.of(roomsRepository.showRoomByNum(rid));
		if(!sRoom.isPresent()) {
			throw new RuntimeException("This room number is not found in database.");
		}
		
		RoomDto dto = new RoomDto();
		dto.setRoomNumber(sRoom.get().getRoomNumber());
		dto.setCapacity(sRoom.get().getCapacity());
		dto.setHasPresenterTools(sRoom.get().getHasPresenterTools());
		
		return dto;
	}
	
	@GetMapping("/rooms")
	public List<RoomDto> getAllDto(){
		List<Room> rList = roomsRepository.findAll();
		List<RoomDto> dtoList = new ArrayList<>();
		rList.stream().forEach(r->{
			RoomDto dto = new RoomDto();
			dto.setRoomNumber(r.getRoomNumber());
			dto.setCapacity(r.getCapacity());
			dto.setHasPresenterTools(r.getHasPresenterTools());
			dtoList.add(dto);
		});
		return dtoList;
	}
	
	@DeleteMapping("/rooms/delete/{rid}")
	public void deleteRoomById(@PathVariable("rid") Integer rid) {
		roomsRepository.deleteById(rid);
	}
	
	@PutMapping("/rooms/update/{rid}")
	public Room updateRoomById(@PathVariable("rid") Integer rid, @RequestBody RoomDto uRoomValue){
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
