package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="checkedoutrooms")
public class CheckedOutRoom {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String strDate;
	
	@Column
	private Integer room;
	
	@Column
	private Integer patron;
	
	@Column
	private LocalDate reservedDate;
	

	public CheckedOutRoom() {
		super();
	}
	
	public CheckedOutRoom(String reservedDate, Integer room, Integer patron) {
		super();
		this.strDate = reservedDate;
		this.room = room;
		this.patron = patron;
	}

	
	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public LocalDate getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(LocalDate reservedDate) {
		this.reservedDate = reservedDate;
	}

	public Integer getRoom() {
		return room;
	}

	public void setRoom(Integer room) {
		this.room = room;
	}

	public Integer getPatron() {
		return patron;
	}

	public void setPatron(Integer patron) {
		this.patron = patron;
	}

	@Override
	public String toString() {
		return "The room is "+room+", and is being reserved by "+ patron+" on "+ reservedDate +".";
	}
	
	
}
