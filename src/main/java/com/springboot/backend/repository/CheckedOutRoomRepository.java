package com.springboot.backend.repository;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.model.CheckedOutRoom;

public interface CheckedOutRoomRepository extends JpaRepository<CheckedOutRoom, Integer> {
	//view room collection
	@Query("select cr from CheckedOutRoom cr where cr.patron=?1")
	List<CheckedOutRoom> showReservationsByPatron(Integer pid);
	@Query("select cr from CheckedOutRoom cr where cr.room=?1")
	CheckedOutRoom showReservationByRoomNum(Integer rNum);
	
	//delete reservation
	@Transactional
	@Modifying
	@Query("delete from CheckedOutRoom cr where cr.room = ?1")
	void deleteReservation(Integer rNum);
	
	

	//edit a reservation
	@Transactional
	@Modifying
	@Query("update CheckedOutRoom cr set cr.patron = ?1 where cr.room=?2")
	void changeReservationPatron(Integer pid, Integer rNum);
	
	@Transactional
	@Modifying
	@Query("update CheckedOutRoom cr set cr.room = ?1 where cr.patron=?2")
	void changeReservationRoom(Integer rNum, Integer pid);
	
	@Transactional
	@Modifying
	@Query("update CheckedOutRoom cr set cr.reservedDate=?1 where cr.patron=?2")
	void changeReservationDate(LocalDate date, Integer pid);

}
