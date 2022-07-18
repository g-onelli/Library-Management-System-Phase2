package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "checkedoutbooks")
public class CheckedOutBook{

	    @Id
	    private int patrons_id;
	    @Id
	    private int books_id;
	    @Column
	    private LocalDate dueDate;

	    public CheckedOutBook() {
	        super();
	    }

	    public CheckedOutBook(int patrons_id, int books_id, LocalDate dueDate) {
	        super();
	        this.patrons_id = patrons_id;
	        this.books_id = books_id;
	        this.dueDate = dueDate;
	    }

	    @Override
	    public String toString() {
	        return "checkedOutBook [patrons_id=" + patrons_id + ", videos_id=" + books_id + ", dueDate="
	                + dueDate + "]";
	    }

	    public int getPatrons_id() {
	        return patrons_id;
	    }

	    public void setPatrons_id(int patrons_id) {
	        this.patrons_id = patrons_id;
	    }

	    public int getBooks_id() {
	        return books_id;
	    }

	    public void setBooks_id(int books_id) {
	        this.books_id = books_id;
	    }

	    public LocalDate getDueDate() {
	        return dueDate;
	    }

	    public void setDueDate(LocalDate date) {
	        this.dueDate = date;
	    }

}
