package com.springboot.backend.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer>{

	@Query("select r from Request r where r.id=?1")
	Optional<Request> findByRid(Integer id);
	
}
