package com.springboot.backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer>{
	
}
