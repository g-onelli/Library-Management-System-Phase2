package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 45)
    private String title;
	@Column(length = 45)
    private String author;
	@Column(length = 45)
    private String publisher;
	@Column
    private Double callNumber;
    @Column(length = 45)
    private String genre;

    public Book(){
        super();
    }

    public Book(int id, String title, String author, String publisher, Double callNumber, String genre) {
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
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", callNumber=" + callNumber +
                ", genre='" + genre + '\'' +
                '}';
    }

}
