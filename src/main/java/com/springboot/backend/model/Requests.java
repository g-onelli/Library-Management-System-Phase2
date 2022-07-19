package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requests")
public class Requests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	@Column(length = 45, nullable = true)
    private String description;
	@Column(nullable = true)
    private LocalDate submissionDate;
	@Column(length = 45, nullable = true)
    private String title;
	@Column(length = 45, nullable = false)
    private String author;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", description=" + description + ", submissionDate=" + submissionDate + ", title="
				+ title + ", author=" + author + "]";
	}
	public Requests(int id, String description, LocalDate submissionDate, String title, String author) {
		super();
		this.id = id;
		this.description = description;
		this.submissionDate = submissionDate;
		this.title = title;
		this.author = author;
	}
	public Requests() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
