package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "checkedoutvideos")
public class CheckedOutVideo{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade= {CascadeType.ALL}) 
	private Patron patron;
	
	@OneToOne(cascade= {CascadeType.ALL}) 
    private Video video;
	
    @Column
    private LocalDate dueDate;

	public CheckedOutVideo() {
		super();
	}

	public CheckedOutVideo(int id, Patron patron, Video video, LocalDate dueDate) {
		super();
		this.id = id;
		this.patron = patron;
		this.video = video;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "CheckedOutVideo [id=" + id + ", patron=" + patron + ", video=" + video + ", dueDate=" + dueDate + "]";
	}

   

}
