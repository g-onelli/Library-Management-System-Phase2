package com.springboot.backend.dto;

import java.time.LocalDate;

public class PatronDto {
	private Integer id;
	private String name;
	private LocalDate cardexpirationdate;
	private Double balance;
	private Integer uid;
	private String username;
	private String role;
	private String encodedCredentials;
	private Integer totalpages;
	private String securityQuestion;
	private String securityAnswer;
	private LocalDate passwordLastReset;
	public String getEncodedCredentials() {
		return encodedCredentials;
	}
	public void setEncodedCredentials(String encodedCredentials) {
		this.encodedCredentials = encodedCredentials;
	}
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
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(Integer totalpages) {
		this.totalpages = totalpages;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public LocalDate getPasswordLastReset() {
		return passwordLastReset;
	}
	public void setPasswordLastReset(LocalDate passwordLastReset) {
		this.passwordLastReset = passwordLastReset;
	}
	
}
