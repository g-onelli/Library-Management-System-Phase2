package com.springboot.backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.CheckedOutRoomDto;
import com.springboot.backend.dto.ReservationDto;
import com.springboot.backend.dto.UpdateDto;
import com.springboot.backend.model.CheckedOutRoom;
import com.springboot.backend.model.Patron;
import com.springboot.backend.model.Reservation;
import com.springboot.backend.model.Room;
import com.springboot.backend.repository.CheckedOutRoomRepository;
import com.springboot.backend.repository.PatronRepository;
import com.springboot.backend.repository.RoomsRepository;

@RestController
public class CheckedOutRoomController {
	@Autowired
	private CheckedOutRoomRepository checkedOutRoomRepository;
	
	@Autowired
	private RoomsRepository roomRepository;
	
	@Autowired
	private PatronRepository patronRepository;
	
	private String returnEndTime(String startTime, Double duration) {
		String[] splitTime = startTime.split(":");
		int hr =0;
		int min = 0;
		if(duration.toString().contains(".")) {
			String[] splitDur = duration.toString().split("[.]");
			hr = Integer.parseInt(splitTime[0])+Integer.parseInt(splitDur[0]);
			min = Integer.parseInt(splitTime[1])+Integer.parseInt(splitDur[1]);
		}
		else {
			String time = duration.toString();
			hr = Integer.parseInt(splitTime[0])+Integer.parseInt(time);
		}
		if(min>=60) {
			hr+=1;
			min= min-60;
		}
		if(hr>=25) {
			hr-=25;
		}
		String strEndTime = Integer.toString(hr)+"."+Integer.toString(min);
		return strEndTime;
	}
	
	@PostMapping("/reservation/create")
	public void makeReservations(@RequestBody ReservationDto reserve) {
		LocalDate ldObj = LocalDate.parse(reserve.getStrDate());
		Optional<Patron> patron = patronRepository.findById(reserve.getPatronId());
		System.out.println(patron);
		Room room = roomRepository.showRoomByNum(reserve.getRoomNumber());
		System.out.println(room);
		CheckedOutRoom newReserve = new CheckedOutRoom();
		newReserve.setduration(reserve.getDuration());
		newReserve.setStartTime(reserve.getTime());
		newReserve.setPatron(patron.get());
		newReserve.setReservedDate(ldObj);
		newReserve.setStrDate(reserve.getStrDate());
		newReserve.setRoom(room);
		String endTime = returnEndTime(newReserve.getStartTime(), newReserve.getduration());
		Optional<CheckedOutRoom> checkRoom = checkedOutRoomRepository
				.checkAlreadyPresent(newReserve.getRoom().getRoomNumber(),
						newReserve.getStrDate(),
						newReserve.getStartTime(),endTime);
		if(checkRoom.isPresent()) {
			throw new RuntimeException("This room is already reserved on that day during that time slot. Please pick again.");
		}
		else {
			checkedOutRoomRepository.save(newReserve);
		}
		
	}
	 
	
	//Show all rooms that are checked out
	@GetMapping("/reservations")
	public List<CheckedOutRoomDto> showAllReservations(){
		List<CheckedOutRoom> reservList = checkedOutRoomRepository.findAll();
		System.out.println(reservList);
		List<CheckedOutRoomDto> resList = new ArrayList<>();
		reservList.stream().forEach(r->{
			CheckedOutRoomDto room = new CheckedOutRoomDto();
			room.setCapacity(r.getRoom().getCapacity());
			room.setDuration(r.getduration());
			room.setReservedTime(r.getTime());
			room.setPatronId(r.getPatron().getId());
			room.setPatronName(r.getPatron().getName());
			room.setPresentorTools(r.getRoom().getHasPresenterTools());
			room.setReservedDate(r.getStrDate());
			room.setRoomNumber(r.getRoom().getRoomNumber());
			resList.add(room);
			});
		return resList;
	}
	
	//Show all rooms checked out by a single patron
	@GetMapping("/reservation/patron/{pid}")
	public List<CheckedOutRoomDto> showPatronReservations(@PathVariable("pid") Integer pid){
		List<CheckedOutRoom> reservation = checkedOutRoomRepository.showReservationsByPatron(pid);
		List<CheckedOutRoomDto> resList = new ArrayList<>();
		reservation.stream().forEach(r->{
			CheckedOutRoomDto room = new CheckedOutRoomDto();
			room.setCapacity(r.getRoom().getCapacity());
			room.setDuration(r.getduration());
			room.setReservedTime(r.getTime());
			room.setPatronId(r.getPatron().getId());
			room.setPatronName(r.getPatron().getName());
			room.setPresentorTools(r.getRoom().getHasPresenterTools());
			room.setReservedDate(r.getStrDate());
			room.setRoomNumber(r.getRoom().getRoomNumber());
			resList.add(room);
			});
		return resList;
	}
	//Show a specific room by room number
	@GetMapping("/reservation/room/{rNum}")
	public CheckedOutRoomDto showRoomReservation(@PathVariable("rNum") Integer rNum) {
		CheckedOutRoom reservation = checkedOutRoomRepository.showReservationByRoomNum(rNum);
		CheckedOutRoomDto room = new CheckedOutRoomDto();
		room.setCapacity(reservation.getRoom().getCapacity());
		room.setDuration(reservation.getduration());
		room.setReservedTime(reservation.getTime());
		room.setPatronId(reservation.getPatron().getId());
		room.setPatronName(reservation.getPatron().getName());
		room.setPresentorTools(reservation.getRoom().getHasPresenterTools());
		room.setReservedDate(reservation.getStrDate());
		room.setRoomNumber(reservation.getRoom().getRoomNumber());
		return room;
	}
	//Delete reservation

	@DeleteMapping("/reservation/delete")
	public void deleteReservation(@RequestParam(name="rNum") Integer rNum, @RequestParam(name="strDate") String strDate) {
		Room rumNum = roomRepository.showRoomByNum(rNum);
		System.out.println(rumNum);
		System.out.println(rumNum.getNum());
		checkedOutRoomRepository.deleteReservation(rumNum.getNum(), strDate);

	}
	//Edit reservation - room, date, patron
	@PutMapping("/reservation/update/patron")
	public void changePatron(@RequestParam(name="pid") Integer pid, @RequestParam(name="rNum") Integer rNum) {
		Optional<CheckedOutRoom> reservation = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(rNum));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationPatron(pid, rNum);
	}

	@PutMapping("/reservation/update/room")
	public void changeRoom(@RequestBody UpdateDto updateObj) {
	//	Integer nNum = new Integer(updateModel.getIntValue());
		Optional<CheckedOutRoom> oldRoom = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(updateObj.getroomNum()));
		Optional<CheckedOutRoom> newRoom = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(updateObj.getIntValue()));
		System.out.println(newRoom.isPresent());
		if(!oldRoom.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		if(newRoom.isPresent()) {
			throw new RuntimeException("The new room you want to book is already reserved. Please try again later.");
		}
		CheckedOutRoom reservation = checkedOutRoomRepository.showReservationByRoomNum(updateObj.getroomNum());
		Room room = roomRepository.showRoomByNum(updateObj.getIntValue());
		checkedOutRoomRepository.changeReservationRoom(room.getNum(),reservation.getPatron().getId());
	}
	
	@PutMapping("/reservation/update/date")
	public void changeDate(@RequestBody UpdateDto updateObj) {
		Optional<CheckedOutRoom> reservation = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(updateObj.getroomNum()));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationDate(LocalDate.parse(updateObj.getStrDate()), updateObj.getStrDate(),reservation.get().getPatron().getId());
	}
	
	@PutMapping("/reservation/update/duration")
	public void changeDuration(@RequestBody UpdateDto updateObj) {
		Optional<CheckedOutRoom> reservation = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(updateObj.getroomNum()));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationDuration(updateObj.getIntValue(), reservation.get().getPatron().getId());
	}
	

	

}
