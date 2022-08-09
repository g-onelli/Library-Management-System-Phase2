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
	
/*	@PostMapping("/mReservations")
	public void makeReservation(@RequestBody CheckedOutRoom reserve) {
		LocalDate ldObj = LocalDate.parse(reserve.getStrDate());
		reserve.setReservedDate(ldObj);
		checkedOutRoomRepository.save(reserve);
	}*/
	@PostMapping("/mReservations")
	public void makeReservations(@RequestBody ReservationDto reserve) {
		LocalDate ldObj = LocalDate.parse(reserve.getStrDate());
		Optional<Patron> patron = patronRepository.findById(reserve.getPatronId());
		System.out.println(patron);
		Room room = roomRepository.showRoomByNum(reserve.getRoomNumber());
		System.out.println(room);
		CheckedOutRoom newReserve = new CheckedOutRoom();
		newReserve.setduration(reserve.getDuration());
		newReserve.setPatron(patron.get());
		newReserve.setReservedDate(ldObj);
		newReserve.setStrDate(reserve.getStrDate());
		newReserve.setRoom(room);
		System.out.println(newReserve);
		
		checkedOutRoomRepository.save(newReserve);
	}
	 
	
	//Show all rooms that are checked out
	@GetMapping("/reservations")
	public List<CheckedOutRoomDto> showAllReservations(){
		List<CheckedOutRoom> reservList = checkedOutRoomRepository.findAll();
		List<CheckedOutRoomDto> resList = new ArrayList<>();
		reservList.stream().forEach(r->{
			CheckedOutRoomDto room = new CheckedOutRoomDto();
			room.setCapacity(r.getRoom().getCapacity());
			room.setDuration(r.getduration());
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
	@GetMapping("/reservations/patron/{pid}")
	public List<CheckedOutRoomDto> showPatronReservations(@PathVariable("pid") Integer pid){
		List<CheckedOutRoom> reservation = checkedOutRoomRepository.showReservationsByPatron(pid);
		List<CheckedOutRoomDto> resList = new ArrayList<>();
		reservation.stream().forEach(r->{
			CheckedOutRoomDto room = new CheckedOutRoomDto();
			room.setCapacity(r.getRoom().getCapacity());
			room.setDuration(r.getduration());
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
	@GetMapping("/reservations/room/{rNum}")
	public CheckedOutRoomDto showRoomReservation(@PathVariable("rNum") Integer rNum) {
		CheckedOutRoom reservation = checkedOutRoomRepository.showReservationByRoomNum(rNum);
		CheckedOutRoomDto room = new CheckedOutRoomDto();
		room.setCapacity(reservation.getRoom().getCapacity());
		room.setDuration(reservation.getduration());
		room.setPatronId(reservation.getPatron().getId());
		room.setPatronName(reservation.getPatron().getName());
		room.setPresentorTools(reservation.getRoom().getHasPresenterTools());
		room.setReservedDate(reservation.getStrDate());
		room.setRoomNumber(reservation.getRoom().getRoomNumber());
		return room;
	}
	//Delete reservation
	@DeleteMapping("/reservation/delete/{rNum}")
	public void deleteReservation(@PathVariable("rNum") Integer rNum) {
		checkedOutRoomRepository.deleteReservation(rNum);
	}
	//Edit reservation - room, date, patron
	@PutMapping("/reservation/cPatron")
	public void changePatron(@RequestParam(name="pid") Integer pid, @RequestParam(name="rNum") Integer rNum) {
		Optional<CheckedOutRoom> reservation = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(rNum));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationPatron(pid, rNum);
	}

	@PutMapping("/reservation/cRoom")
	public void changeRoom(@RequestParam(name="old") Integer oNum, @RequestParam(name="new") Integer nNum) {
		System.out.println(nNum);
		Optional<CheckedOutRoom> oldRoom = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(oNum));
		Optional<CheckedOutRoom> newRoom = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(nNum));
		System.out.println(newRoom.isPresent());
		if(!oldRoom.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		if(newRoom.isPresent()) {
			throw new RuntimeException("The new room you want to book is already reserved. Please try again later.");
		}
		CheckedOutRoom reservation = checkedOutRoomRepository.showReservationByRoomNum(oNum);
		checkedOutRoomRepository.changeReservationRoom(nNum,reservation.getPatron().getId());
	}
	
	@PutMapping("/reservation/cDate")
	public void changeDate(@RequestParam(name="rNum") Integer rNum, @RequestParam(name="strDate") String strDate) {
		Optional<CheckedOutRoom> reservation = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(rNum));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationDate(LocalDate.parse(strDate), strDate,reservation.get().getPatron().getId());
	}
	
	@PutMapping("/reservation/cDuration")
	public void changeDuration(@RequestParam(name="rNum") Integer rNum, @RequestParam(name="time") int time) {
		Optional<CheckedOutRoom> reservation = Optional.ofNullable(checkedOutRoomRepository.showReservationByRoomNum(rNum));
		if(!reservation.isPresent()) {
			throw new RuntimeException("There is no room currently checked out with this room number.");
		}
		checkedOutRoomRepository.changeReservationDuration(time, reservation.get().getPatron().getId());
	}
	

	

}
