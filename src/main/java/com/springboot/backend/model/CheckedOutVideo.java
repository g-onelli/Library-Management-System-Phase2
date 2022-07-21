package com.springboot.backend.model;

import java.time.LocalDate;

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
<<<<<<< Updated upstream
	@ManyToMany
	private Patrons patron;
	@ManyToMany
=======
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Patron patron;
	
	@OneToOne
>>>>>>> Stashed changes
    private Video video;
	
    @Column
    private LocalDate dueDate;

	public CheckedOutVideo() {
		super();
	}

<<<<<<< Updated upstream
	public CheckedOutVideo(Patrons patron, Video video, LocalDate dueDate) {
=======
	public CheckedOutVideo(int id, Patron patron, Video video, LocalDate dueDate) {
>>>>>>> Stashed changes
		super();
		this.id = id;
		this.patron = patron;
		this.video = video;
		this.dueDate = dueDate;
	}

<<<<<<< Updated upstream
	public Patrons getPatron() {
=======
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patron getPatron() {
>>>>>>> Stashed changes
		return patron;
	}

	public void setPatron(Patrons patron) {
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
