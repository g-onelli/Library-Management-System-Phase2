package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "checkedoutvideos")
public class CheckedOutVideo{
	@ManyToMany
	private Patron patron;
	@ManyToMany
    private Video video;
    @Column
    private LocalDate dueDate;
	
    public CheckedOutVideo() {
		super();
	}

	public CheckedOutVideo(Patron patron, Video video, LocalDate dueDate) {
		super();
		this.patron = patron;
		this.video = video;
		this.dueDate = dueDate;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "CheckedOutVideo [video=" + video + ", dueDate=" + dueDate + "]";
	}
    
	
    
	
    
    

   

}
