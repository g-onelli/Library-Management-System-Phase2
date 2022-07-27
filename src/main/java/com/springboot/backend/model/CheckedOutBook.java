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
@Table(name = "checkedoutbooks")
public class CheckedOutBook{
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;

	    @OneToOne
	    private Patron patron;
	    
	    @OneToOne
	    private Book book;
	    
	    @Column
	    private LocalDate dueDate;

		public CheckedOutBook() {
			super();
		}

		public CheckedOutBook(int id, Patron patron, Book book, LocalDate dueDate) {
			super();
			this.id = id;
			this.patron = patron;
			this.book = book;
			this.dueDate = dueDate;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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
			return "CheckedOutBook [id=" + id + ", patron=" + patron + ", book=" + book + ", dueDate=" + dueDate + "]";
		}


}
