package com.springboot.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Room;

public interface RoomsRepository extends JpaRepository<Room, Integer> {
	@Query("select r from Room r where r.roomNumber=?1")
	Room showRoomByNum(Integer rNum);

    @Query("select cr.room.num from CheckedOutRoom cr where cr.strDate!=?1 and (cr.startTime not BETWEEN ?2 AND ?3 )")
	List<Integer> getRoomNumbers(String parse, String startTime, String endTime);
    
    @Query("select r from Room r where r.num in (:excludeList)")
    List<Room> showOpenRooms(List<Integer> excludeList);
	
}
