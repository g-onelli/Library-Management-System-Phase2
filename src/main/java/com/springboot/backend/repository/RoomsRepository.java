package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Room;

public interface RoomsRepository extends JpaRepository<Room, Integer> {
	@Query("select r from Room r where r.roomNumber=?1")
	Room showRoomByNum(Integer rNum);
}
