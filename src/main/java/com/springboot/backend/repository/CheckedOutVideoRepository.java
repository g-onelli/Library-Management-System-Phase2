package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.CheckedOutVideo;

public interface CheckedOutVideoRepository extends JpaRepository<CheckedOutVideo, Integer>{
	
	@Query("select cv from CheckedOutVideo cv where cv.patron.id = ?1")
	List<CheckedOutVideo> getCheckedOutVideosByPatronId(Integer pid);
	
	@Query("select cv from CheckedOutVideo cv where cv.video.id = ?1")
	List<CheckedOutVideo> getCheckedOutVideosByVideoId(Integer vid);
	
	@Query("delete from CheckedOutVideo cv where cv.patron.id = ?1")
	void deleteCheckedOutVideoByPatronId(Integer pid);
	
	@Query("delete from CheckedOutVideo cv where cv.video.id = ?1")
	void deleteCheckedOutVideosByVideoId(Integer vid);

}
