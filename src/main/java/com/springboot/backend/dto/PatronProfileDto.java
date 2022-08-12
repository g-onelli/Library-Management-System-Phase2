package com.springboot.backend.dto;

import java.time.LocalDate;

public class PatronProfileDto {
    private Integer id;
	private String name;
	private LocalDate cardexpirationdate;
	private Integer uid;
	private String username;
	private String securityQuestion;
	private String securityAnswer;
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
	@Override
	public String toString() {
		return "PatronProfileDto [id=" + id + ", name=" + name + ", cardexpirationdate=" + cardexpirationdate + ", uid="
				+ uid + ", username=" + username + ", securityQuestion=" + securityQuestion + ", securityAnswer="
				+ securityAnswer + "]";
	}
	public PatronProfileDto(Integer id, String name, LocalDate cardexpirationdate, Integer uid, String username,
			String securityQuestion, String securityAnswer) {
		super();
		this.id = id;
		this.name = name;
		this.cardexpirationdate = cardexpirationdate;
		this.uid = uid;
		this.username = username;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	public PatronProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
