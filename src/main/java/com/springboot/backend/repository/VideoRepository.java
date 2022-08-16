package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{
	
	@Query(value = "select * from videos where id NOT IN (select video_id from checkedoutvideos)", nativeQuery = true)
	List<Video> getAvailableVideos();

}
