package com.springboot.backend.dto;

import java.time.LocalDate;

public class CheckedOutBookDto {
	
	private int id;
	private int pId;
	private String pName;
	private LocalDate pCardExpirationDate;
	private double pBalance;
	private int bId;
	private String bTitle;
	private String bAuthor;
	private String bPublisher;
	private double bCallNumber;
	private String bGenre;
	private LocalDate dueDate;
	
	public CheckedOutBookDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckedOutBookDto(int id, int pId, String pName, LocalDate pCardExpirationDate, double pBalance, int bId,
			String bTitle, String bAuthor, String bPublisher, double bCallNumber, String bGenre, LocalDate dueDate) {
		super();
		this.id = id;
		this.pId = pId;
		this.pName = pName;
		this.pCardExpirationDate = pCardExpirationDate;
		this.pBalance = pBalance;
		this.bId = bId;
		this.bTitle = bTitle;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
		this.bCallNumber = bCallNumber;
		this.bGenre = bGenre;
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public LocalDate getpCardExpirationDate() {
		return pCardExpirationDate;
	}

	public void setpCardExpirationDate(LocalDate pCardExpirationDate) {
		this.pCardExpirationDate = pCardExpirationDate;
	}

	public double getpBalance() {
		return pBalance;
	}

	public void setpBalance(double pBalance) {
		this.pBalance = pBalance;
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbPublisher() {
		return bPublisher;
	}

	public void setbPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
	}

	public double getbCallNumber() {
		return bCallNumber;
	}

	public void setbCallNumber(double bCallNumber) {
		this.bCallNumber = bCallNumber;
	}

	public String getbGenre() {
		return bGenre;
	}

	public void setbGenre(String bGenre) {
		this.bGenre = bGenre;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "CheckedOutBookDto [id=" + id + ", pId=" + pId + ", pName=" + pName + ", pCardExpirationDate="
				+ pCardExpirationDate + ", pBalance=" + pBalance + ", bId=" + bId + ", bTitle=" + bTitle + ", bAuthor="
				+ bAuthor + ", bPublisher=" + bPublisher + ", bCallNumber=" + bCallNumber + ", bGenre=" + bGenre
				+ ", dueDate=" + dueDate + "]";
	}
	
	
	
	
}
