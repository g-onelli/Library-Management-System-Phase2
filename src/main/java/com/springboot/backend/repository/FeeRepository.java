package com.springboot.backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Fee;

public interface FeeRepository extends JpaRepository<Fee, Integer>{
	@Query("select f from Fee f where f.patron.id=?1")
	List<Fee> findByFeeId(Integer id);
	
}
