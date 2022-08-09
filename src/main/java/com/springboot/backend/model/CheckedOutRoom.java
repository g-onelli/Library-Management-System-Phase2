package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
	
	@Column
	private String strDate;
	
	@OneToOne
	private Room room;
	
	@OneToOne
	private Patron patron;
	
	@Column
	private LocalDate reservedDate;
	
	@Column
	private int duration;
	

	public CheckedOutRoom() {
		super();
	}
	
	public CheckedOutRoom(String strDate, Room room, Patron patron, int duration) {
		super();
		this.strDate = strDate;
		this.room = room;
		this.patron = patron;
		this.duration = duration;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}

	public int getduration() {
		return duration;
	}

	public void setduration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "The room is "+room.getRoomNumber()+", and is being reserved by "+ patron.getName()+" on "+ reservedDate +".";
	}
	
	
}
