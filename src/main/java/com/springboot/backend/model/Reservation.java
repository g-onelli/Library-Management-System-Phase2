package com.springboot.backend.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.repository.BookRepository;

@Entity
@Table(name = "reservation")
public class Reservation {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private Integer patronId;
	@Column
	private Integer roomNum;
	@Column
	private String reserveDate;
	
	
	public Reservation() {
		super();
	}

	public Reservation(Integer id, Integer patronId, Integer roomNum, String reserveDate) {
		super();
		this.id = id;
		this.patronId = patronId;
		this.roomNum = roomNum;
		this.reserveDate = reserveDate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatronId() {
		return patronId;
	}
	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	@Override
	public String toString() {
		return "A reservation is being made for room "+roomNum+" by "+patronId+" for "+reserveDate;
	}
	
}
