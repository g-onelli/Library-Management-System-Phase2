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
	
	@PostMapping("/mReservations")
	public void makeReservation(@RequestBody CheckedOutRoom reserve) {
		LocalDate ldObj = LocalDate.parse(reserve.getStrDate());
		reserve.setReservedDate(ldObj);
		checkedOutRoomRepository.save(reserve);
	}
	
	//Show all rooms that are checked out
	@GetMapping("/reservations")
	public List<CheckedOutRoom> showAllReservations(){
		List<CheckedOutRoom> reservList = checkedOutRoomRepository.findAll();
		return reservList;
	}
	
	//Show all rooms checked out by a single patron
	@GetMapping("/reservations/patron/{pid}")
	public CheckedOutRoom showPatronReservations(@PathVariable("pid") Integer pid){
		CheckedOutRoom reservation = checkedOutRoomRepository.showReservationsByPatron(pid);
		return reservation;
	}
	//Show a specific room by room number
	@GetMapping("/reservations/room/{rNum}")
	public CheckedOutRoom showRoomReservation(@PathVariable("rNum") Integer rNum) {
		CheckedOutRoom reservation = checkedOutRoomRepository.showReservationByRoomNum(rNum);
		return reservation;
	}
	//Delete reservation
	@DeleteMapping("/reservation/delete/{rNum}")
	public void deleteReservation(@PathVariable("rNum") Integer rNum) {
		checkedOutRoomRepository.deleteReservation(rNum);
	}/*
	//Edit reservation - room, date, patron
	@PutMapping("/reservation/cPatron/{pid}/{rNum}")
	public void changePatron(@PathVariable("pid") Integer pid, @PathVariable("rNum") Integer rNum) {
		Optional<CheckedOutRoom> reservation = Optional.of(checkedOutRoomRepository.showReservationByRoomNum(rNum));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationPatron(pid, rNum);
	}
	
	@PutMapping("/reservation/cRoom/{oNum}/{nNum}")
	public void changeRoom(@PathVariable("oNum") Integer oNum, @PathVariable("nNum") Integer nNum) {
		Optional<CheckedOutRoom> oldRoom = Optional.of(checkedOutRoomRepository.showReservationByRoomNum(oNum));
		Optional<CheckedOutRoom> newRoom = Optional.of(checkedOutRoomRepository.showReservationByRoomNum(nNum));
		if(!oldRoom.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		if(newRoom.isPresent()) {
			throw new RuntimeException("The new room you want to book is already reserved. Please try again later.");
		}
		CheckedOutRoom reservation = checkedOutRoomRepository.showReservationByRoomNum(oNum);
		checkedOutRoomRepository.changeReservationRoom(reservation.getPatron().getId(), nNum);
	}
	
	@PutMapping("/reservation/cPatron/{pid}/{date}")
	public void changeDate(@PathVariable("pid") Integer pid, @PathVariable("date") LocalDate date) {
		Optional<CheckedOutRoom> reservation = Optional.of(checkedOutRoomRepository.showReservationsByPatron(pid));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationDate(date, pid);
	}
	
	*/
	

}
