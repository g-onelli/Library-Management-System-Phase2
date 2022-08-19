package com.springboot.backend.repository;



import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.model.CheckedOutRoom;

public interface CheckedOutRoomRepository extends JpaRepository<CheckedOutRoom, Integer> {
	//view room collection
	@Query("select cr from CheckedOutRoom cr where cr.patron.id=?1")
	List<CheckedOutRoom> showReservationsByPatron(Integer pid);
	@Query("select cr from CheckedOutRoom cr where cr.room.roomNumber=?1")
	CheckedOutRoom showReservationByRoomNum(Integer rNum);
	
	@Query("select cr from CheckedOutRoom cr where cr.room.roomNumber=?1 and cr.strDate=?2 and (cr.startTime between ?3 and ?4)")
	Optional<CheckedOutRoom> checkAlreadyPresent(Integer rNum, String strdate, String startT, String endT);
	
	//delete reservation
	@Transactional
	@Modifying

	@Query("delete from CheckedOutRoom cr where cr.room.num = ?1 and cr.strDate=?2")
	void deleteReservation(Integer rNum, String strDate);

	
	

	//edit a reservation
	@Transactional
	@Modifying
	@Query("update CheckedOutRoom cr set cr.patron.id = ?1 where cr.room.roomNumber=?2")
	void changeReservationPatron(Integer pid, Integer rNum);
	
	@Transactional
	@Modifying
	@Query("update CheckedOutRoom cr set cr.room.num = ?1 where cr.patron.id=?2")
	void changeReservationRoom(Integer rNum, Integer pid);
	
	@Transactional
	@Modifying
	@Query("update CheckedOutRoom cr set cr.reservedDate=?1, cr.strDate=?2 where cr.patron.id=?3")
	void changeReservationDate(LocalDate aDate, String strDate, Integer pid);
	
	@Transactional
	@Modifying
	@Query("update CheckedOutRoom cr set cr.duration=?1 where cr.patron.id=?2")
	void changeReservationDuration(double time, Integer id);

}
