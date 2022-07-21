package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{

}
