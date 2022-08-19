package com.springboot.backend.dto;

public class UpdateDto {
	private Integer roomNum;
	private String strDate;
	private int intValue;
	
	public UpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateDto(Integer roomNum, String strDate, int intValue) {
		super();
		this.roomNum = roomNum;
		this.strDate = strDate;
		this.intValue = intValue;
	}
	
	
	public Integer getroomNum() {
		return roomNum;
	}
	public void setroomNum(Integer roomNum) {
		this.roomNum = roomNum;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	
	
}
