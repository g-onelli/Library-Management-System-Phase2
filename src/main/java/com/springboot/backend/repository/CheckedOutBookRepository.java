package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.CheckedOutBook;

public interface CheckedOutBookRepository extends JpaRepository<CheckedOutBook, Long>{

	@Query("select cb from CheckedOutBook cb where cb.patron.id = ?1")
	List<CheckedOutBook> getCheckedOutBooksByPatronId(Long pid);
	@Query("select cb from CheckedOutBook cb where cb.book.id = ?1")
	List<CheckedOutBook> getCheckedOutBooksByBookId(Long bid);
	@Query("delete cb from CheckedOutBook cb where cb.patron.id = ?1")
	void deleteCheckedOutBookByPatronId(Long pid);
	@Query("delete cb from CheckedOutBook cb where cb.book.id = ?1")
	void deleteCheckedOutBookByBookId(Long bid);

}
