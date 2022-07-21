package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
