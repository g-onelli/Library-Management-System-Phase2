package com.springboot.backend.dto;

public class CheckedOutRoomDto {
	private int roomNumber;
	private String patronName;
	private Integer patronId;
	private String reservedDate;
	private int duration;
	private int capacity;
	private int presentorTools;
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getPatronName() {
		return patronName;
	}
	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}
	public Integer getPatronId() {
		return patronId;
	}
	public void setPatronId(Integer patronId) {
		this.patronId = patronId;
	}
	public String getReservedDate() {
		return reservedDate;
	}
	public void setReservedDate(String reservedDate) {
		this.reservedDate = reservedDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPresentorTools() {
		return presentorTools;
	}
	public void setPresentorTools(int presentorTools) {
		this.presentorTools = presentorTools;
	}
	
	
}
