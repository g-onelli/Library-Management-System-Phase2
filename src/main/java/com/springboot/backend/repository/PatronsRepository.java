package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.backend.model.Patrons;

public interface PatronsRepository extends JpaRepository<Patrons, Integer>{

}
