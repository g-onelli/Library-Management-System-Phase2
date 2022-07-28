package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer>{
	
}
