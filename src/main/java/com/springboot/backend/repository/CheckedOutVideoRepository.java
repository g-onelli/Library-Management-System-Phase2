package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.CheckedOutVideo;

public interface CheckedOutVideoRepository extends JpaRepository<CheckedOutVideo, Long>{
	
	@Query("select cv from CheckedOutVideo cv where cv.patron.id = ?1")
	List<CheckedOutVideo> getCheckedOutVideosByPatronId(Long pid);
	@Query("select cv from CheckedOutVideo cv where cv.video.id = ?1")
	List<CheckedOutVideo> getCheckedOutVideosByVideoId(Long vid);
	@Query("delete cv from CheckedOutVideo cv where cv.patron.id = ?1")
	void deleteCheckedOutVideoByPatronId(Long pid);
	@Query("delete cv from CheckedOutVideo cv where cv.book.id = ?1")
	void deleteCheckedOutVideosByVideoId(Long vid);

}
