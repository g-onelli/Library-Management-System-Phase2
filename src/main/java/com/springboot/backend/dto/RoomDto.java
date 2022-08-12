package com.springboot.backend.dto;

public class RoomDto {
	private Integer id;
	private Integer roomNumber;
	private Integer capacity;
	private Integer hasPresenterTools;
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getHasPresenterTools() {
		return hasPresenterTools;
	}
	public void setHasPresenterTools(Integer hasPresenterTools) {
		this.hasPresenterTools = hasPresenterTools;
	}
	
}
