package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		
	    private int id;
		
		@Column(length = 45)
	    private String title;
		@Column(length = 45)
	    private String director;
		@Column
	    private String releaseDate;
		@Column
	    private double callNumber;
	    @Column(length = 45)
	    private String genre;

	    public Video(){
	        super();
	    }

	    public Video(int id, String title, String director, String releaseDate, double callNumber, String genre) {
	        super();
	        this.id = id;
	        this.title = title;
	        this.director = director;
	        this.releaseDate = releaseDate;
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

	    public String getDirector() {
	        return director;
	    }

	    public void setDirector(String director) {
	        this.director = director;
	    }

	    public String getReleaseDate() {
	        return releaseDate;
	    }

	    public void setReleaseDate(String releaseDate) {
	        this.releaseDate = releaseDate;
	    }

	    public double getCallNumber() {
	        return callNumber;
	    }

	    public void setCallNumber(double callNumber) {
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
	        return "video{" +
	                "id=" + id +
	                ", title='" + title + '\'' +
	                ", director='" + director + '\'' +
	                ", releaseDate='" + releaseDate + '\'' +
	                ", callNumber=" + callNumber +
	                ", genre='" + genre + '\'' +
	                '}';
	    }
}
