package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("select count(id) from Book")
	Double nextCallNumber();
}
