package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.UserInfo;



public interface UserRepository extends JpaRepository<UserInfo, Integer>{
	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getByUsername(String username);
}
