package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Librarian;



public interface LibrarianRepository extends JpaRepository<Librarian, Integer>{

}
