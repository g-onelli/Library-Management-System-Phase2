package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Rooms;

public interface RoomsRepository extends JpaRepository<Rooms, Integer> {

}
