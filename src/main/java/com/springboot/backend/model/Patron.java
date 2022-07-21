package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patrons")
public class Patron {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	
	@Column(length = 45, nullable = true)
    private String name;
	
	@Column(length = 45, nullable = true)
    private LocalDate cardexpirationdate;
	
	@Column
    private double balance;
    
    @Column(length = 45)
    private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCardexpirationdate() {
		return cardexpirationdate;
	}

	public void setCardexpirationdate(LocalDate cardexpirationdate) {
		this.cardexpirationdate = cardexpirationdate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Patrons [id=" + id + ", name=" + name + ", cardexpirationdate=" + cardexpirationdate + ", balance="
				+ balance + ", password=" + password + "]";
	}

	public Patron(Integer id, String name, LocalDate cardexpirationdate, double balance, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cardexpirationdate = cardexpirationdate;
		this.balance = balance;
		this.password = password;
	}

	public Patron() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}
