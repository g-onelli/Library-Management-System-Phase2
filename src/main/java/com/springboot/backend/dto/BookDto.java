package com.springboot.backend.dto;

public class BookDto {
	private int id;
	private String title;
	private String author;
	private String publisher;
	private Double callNumber;
	private String genre;
	
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDto(int id, String title, String author, String publisher, Double callNumber, String genre) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.callNumber = callNumber;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Double getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(Double callNumber) {
		this.callNumber = callNumber;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", callNumber=" + callNumber + ", genre=" + genre + "]";
	}
	
	
	
	

}
