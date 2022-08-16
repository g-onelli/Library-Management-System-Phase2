package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query("select count(id) from Book")
	Double nextCallNumber();

	@Query(value = "select * from books where id NOT IN (select book_id from checkedoutbooks)", nativeQuery = true)
	List<Book> getAvailableBooks();
}
