package com.springboot.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Room;

public interface RoomsRepository extends JpaRepository<Room, Integer> {
	@Query("select r from Room r where r.roomNumber=?1")
	Room showRoomByNum(Integer rNum);

    @Query("select cr.room from CheckedOutRoom cr where cr.reservedDate!=?1")
	List<Integer> getRoomNumbers(LocalDate parse);
    
    @Query("select r from Room r where r.roomNumber not in (:excludeList)")
    List<Room> showOpenRooms(List<Integer> excludeList);
	
}
