package com.springboot.backend.dto;

public class CheckedOutRoomDto {
	private int id;
	private int roomNumber;
	private String patronName;
	private Integer patronId;
	private String reservedDate;
	private double reservedTime;
	private String startTime;
	private double duration;
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
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
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
	public double getReservedTime() {
		return reservedTime;
	}
	public void setReservedTime(double reservedTime) {
		this.reservedTime = reservedTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	
	
}
