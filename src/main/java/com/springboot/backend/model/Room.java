package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false)
	private Integer num;
	
	@Column
	private Integer roomNumber;
	
	@Column(nullable=false)
	private Integer capacity;
	
	@Column(nullable=false)
	private Integer hasPresenterTools;
	
	public Room(Integer roomNumber, Integer capacity, Integer hasPresenterTools) {
		super();
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.hasPresenterTools = hasPresenterTools;
	}
	
	public Room() {
		super();
	}

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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Room "+roomNumber+" has a space capacity of "+capacity+" people and has "+hasPresenterTools+" presentor tools present.";
	}
	
	
	
	
	

}
