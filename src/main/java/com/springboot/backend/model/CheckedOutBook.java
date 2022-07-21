package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "checkedoutbooks")
public class CheckedOutBook{

	    @OneToMany
	    private Patron patron;
	    @OneToMany
	    private Book book;
	    @Column
	    private LocalDate dueDate;
		
	    public CheckedOutBook() {
			super();
		}

		public CheckedOutBook(Patron patron, Book book, LocalDate dueDate) {
			super();
			this.patron = patron;
			this.book = book;
			this.dueDate = dueDate;
		}

		public Patron getPatron() {
			return patron;
		}

		public void setPatron(Patron patron) {
			this.patron = patron;
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}

		@Override
		public String toString() {
			return "CheckedOutBook [book=" + book + ", dueDate=" + dueDate + "]";
		}
		
		
	    
	    
	    
	    

}
