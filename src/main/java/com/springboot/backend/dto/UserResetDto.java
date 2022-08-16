package com.springboot.backend.dto;

public class UserResetDto {
	private Integer id;
	private String securityQuestion;
	private String securityAnswer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "UserResetDto [id=" + id + ", securityQuestion=" + securityQuestion + ", securityAnswer="
				+ securityAnswer + "]";
	}
	public UserResetDto(Integer id, String securityQuestion, String securityAnswer) {
		super();
		this.id = id;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	public UserResetDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
