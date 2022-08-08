package com.springboot.backend.dto;

import java.time.LocalDate;

public class CheckedOutVideoDto {
	
	private int id;
	private int pId;
	private String pName;
	private LocalDate pCardExpirationDate;
	private double pBalance;
	private int vId;
	private String vTitle;
	private String vDirector;
	private String vReleaseDate;
	private double vCallNumber;
	private String vGenre;
	private LocalDate dueDate;
	
	public CheckedOutVideoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckedOutVideoDto(int id, int pId, String pName, LocalDate pCardExpirationDate, double pBalance, int vId,
			String vTitle, String vDirector, String vReleaseDate, double vCallNumber, String vGenre,
			LocalDate dueDate) {
		super();
		this.id = id;
		this.pId = pId;
		this.pName = pName;
		this.pCardExpirationDate = pCardExpirationDate;
		this.pBalance = pBalance;
		this.vId = vId;
		this.vTitle = vTitle;
		this.vDirector = vDirector;
		this.vReleaseDate = vReleaseDate;
		this.vCallNumber = vCallNumber;
		this.vGenre = vGenre;
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

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getvDirector() {
		return vDirector;
	}

	public void setvDirector(String vDirector) {
		this.vDirector = vDirector;
	}

	public String getvReleaseDate() {
		return vReleaseDate;
	}

	public void setvReleaseDate(String vReleaseDate) {
		this.vReleaseDate = vReleaseDate;
	}

	public double getvCallNumber() {
		return vCallNumber;
	}

	public void setvCallNumber(double vCallNumber) {
		this.vCallNumber = vCallNumber;
	}

	public String getvGenre() {
		return vGenre;
	}

	public void setvGenre(String vGenre) {
		this.vGenre = vGenre;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "CheckedOutVideoDto [id=" + id + ", pId=" + pId + ", pName=" + pName + ", pCardExpirationDate="
				+ pCardExpirationDate + ", pBalance=" + pBalance + ", vId=" + vId + ", vTitle=" + vTitle
				+ ", vDirector=" + vDirector + ", vReleaseDate=" + vReleaseDate + ", vCallNumber=" + vCallNumber
				+ ", vGenre=" + vGenre + ", dueDate=" + dueDate + "]";
	}
	
	
	
	
	

}
