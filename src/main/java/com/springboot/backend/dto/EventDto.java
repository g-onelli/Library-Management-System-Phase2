package com.springboot.backend.dto;

import java.time.LocalDate;
import com.springboot.backend.model.Librarian;

public class EventDto {
	private Integer id;
	private LocalDate date;
	private String description;
	private String title;
	private Librarian librarian;
	private Integer pages;
	
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
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
	
	
	
	
}
