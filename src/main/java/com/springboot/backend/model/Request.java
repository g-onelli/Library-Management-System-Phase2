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
@Table(name = "requests")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	@Column(length = 600, nullable = true)
    private String description;
	@Column(nullable = true)
    private LocalDate submissiondate;
	@Column(length = 100, nullable = true)
    private String title;
	@Column(length = 45, nullable = false)
    private String author;
	@OneToOne(cascade = {CascadeType.DETACH})
	private Patron patron;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getSubmissiondate() {
		return submissiondate;
	}
	public void setSubmissiondate(LocalDate submissiondate) {
		this.submissiondate = submissiondate;
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
	public Patron getPatron() {
		return patron;
	}
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	@Override
	public String toString() {
		return "Requests [id=" + id + ", description=" + description + ", submissiondate=" + submissiondate + ", title="
				+ title + ", author=" + author + ", patron=" + patron + "]";
	}
	public Request(Integer id, String description, LocalDate submissiondate, String title, String author, Patron patron) {
		super();
		this.id = id;
		this.description = description;
		this.submissiondate = submissiondate;
		this.title = title;
		this.author = author;
		this.patron = patron;
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    
}
