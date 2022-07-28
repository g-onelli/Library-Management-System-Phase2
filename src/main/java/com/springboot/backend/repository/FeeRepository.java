package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Fee;

public interface FeeRepository extends JpaRepository<Fee, Integer>{

}
