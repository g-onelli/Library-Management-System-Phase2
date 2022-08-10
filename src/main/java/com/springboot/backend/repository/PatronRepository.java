package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Patron;

public interface PatronRepository extends JpaRepository<Patron, Integer>{
	
}
