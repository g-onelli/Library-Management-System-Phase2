package com.springboot.backend.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.springboot.backend.model.Patron;

public interface PatronRepository extends JpaRepository<Patron, Integer>{

	@Transactional
	@Modifying
	@Query("update Patron p SET p.name=?2,p.cardexpirationdate=?3,p.balance=?4 where p.id=?1")
	void updatePatron(Integer id, String name, LocalDate cardexpirationdate, Double balance);

	@Query("select p from Patron p where p.userinfo.username=?1")
	Patron getByUsername(String username);
	
}
