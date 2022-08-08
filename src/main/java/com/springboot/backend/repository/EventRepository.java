package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{

}
