package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.CheckedOutVideo;

public interface CheckedOutVideoRepository extends JpaRepository<CheckedOutVideo, Long>{

}
