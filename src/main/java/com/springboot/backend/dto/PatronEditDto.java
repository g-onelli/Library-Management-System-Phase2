package com.springboot.backend.dto;

import java.time.LocalDate;

public class PatronEditDto {
	private Integer id;
	private String name;
	private LocalDate cardexpirationdate;
	private Double balance;
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
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public PatronEditDto(Integer id, String name, LocalDate cardexpirationdate, Double balance) {
		super();
		this.id = id;
		this.name = name;
		this.cardexpirationdate = cardexpirationdate;
		this.balance = balance;
	}
	public PatronEditDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
