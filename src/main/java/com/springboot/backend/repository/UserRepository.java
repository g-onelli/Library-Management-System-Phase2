package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

import javax.transaction.Transactional;
import com.springboot.backend.model.UserInfo;



public interface UserRepository extends JpaRepository<UserInfo, Integer>{
	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getByUsername(String username);
	@Transactional
	@Modifying
	@Query("update UserInfo u SET u.password=?2,u.passwordLastReset=?3 where u.username=?1")
	void resetPassword(String username, String password,LocalDate date);
	
	@Transactional
	@Modifying
	@Query("update UserInfo u SET u.securityQuestion=?2,u.securityAnswer=?3 where u.username=?1")
	void updateProfile(String username, String securityQuestion, String securityAnswer);
}
