package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patrons")
public class Patrons {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	
	@Column(length = 45, nullable = true)
    private String name;
	
	@Column(length = 45, nullable = true)
    private String cardExpirationDate;
	
	@Column
    private double balance;
    
    @Column(length = 45)
    private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardExpirationDate() {
		return cardExpirationDate;
	}

	public void setCardExpirationDate(String cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
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
		return "Patron [id=" + id + ", name=" + name + ", cardExpirationDate=" + cardExpirationDate + ", balance="
				+ balance + ", password=" + password + "]";
	}

	public Patrons(int id, String name, String cardExpirationDate, double balance, String password) {
		super();
		this.id = id;
		this.name = name;
		this.cardExpirationDate = cardExpirationDate;
		this.balance = balance;
		this.password = password;
	}

	public Patrons() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
