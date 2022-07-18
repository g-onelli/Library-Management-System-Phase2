package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.CheckedOutBook;

public interface CheckedOutBookRepository extends JpaRepository<CheckedOutBook, Long>{

}
