package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.CheckedOutBook;

public interface CheckedOutBookRepository extends JpaRepository<CheckedOutBook, Integer>{

	@Query("select cb from CheckedOutBook cb where cb.patron.id = ?1")
	List<CheckedOutBook> getCheckedOutBooksByPatronId(Integer pid);
	@Query("select cb from CheckedOutBook cb where cb.book.id = ?1")
	List<CheckedOutBook> getCheckedOutBooksByBookId(Integer bid);
	@Query("delete from CheckedOutBook cb where cb.patron.id = ?1")
	void deleteCheckedOutBookByPatronId(Integer pid);
	@Query("delete from CheckedOutBook cb where cb.book.id = ?1")
	void deleteCheckedOutBookByBookId(Integer bid);

}
