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
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(length = 600, nullable = true)
	private String description;
	
	@Column(length = 100, nullable = true)
	private String title;
	
	@OneToOne(cascade = {CascadeType.DETACH})
	private Librarian librarian;

	public Event(Integer id, LocalDate date, String description, String title, Librarian librarian) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.title = title;
		this.librarian = librarian;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", description=" + description + ", title=" + title
				+ ", librarian=" + librarian + "]";
	}
	
	
}
