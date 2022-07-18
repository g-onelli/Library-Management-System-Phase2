package com.springboot.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Requests;

public interface RequestsRepository extends JpaRepository<Requests, Integer>{

}
