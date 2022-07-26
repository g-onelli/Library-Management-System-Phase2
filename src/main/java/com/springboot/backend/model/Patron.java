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
    @OneToOne
	private UserInfo userinfo;
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
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	@Override
	public String toString() {
		return "Patron [id=" + id + ", name=" + name + ", cardexpirationdate=" + cardexpirationdate + ", balance="
				+ balance + ", userinfo=" + userinfo + "]";
	}
	public Patron(Integer id, String name, LocalDate cardexpirationdate, double balance, UserInfo userinfo) {
		super();
		this.id = id;
		this.name = name;
		this.cardexpirationdate = cardexpirationdate;
		this.balance = balance;
		this.userinfo = userinfo;
	}
	public Patron() {
		super();
		// TODO Auto-generated constructor stub
	}
      
}
