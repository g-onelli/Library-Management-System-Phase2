package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Librarian;



public interface LibrarianRepository extends JpaRepository<Librarian, Integer>{
	@Query("select l from Librarian l where l.userinfo.username=?1")
	Librarian getByUsername(String username);
}
