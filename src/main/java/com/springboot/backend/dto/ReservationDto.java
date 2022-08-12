package com.springboot.backend.dto;

public class ReservationDto {
	private int patronId;
	private int roomNumber;
	private double duration;
	private String time;
	private String strDate;
	
	
	public int getPatronId() {
		return patronId;
	}
	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
