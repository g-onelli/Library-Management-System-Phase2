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
	private double duration;
	
	@Column
	private double time;
	
	@Column
	private String startTime;
	

	public CheckedOutRoom() {
		super();
	}
	



	public CheckedOutRoom(String strDate, Room room, Patron patron, LocalDate reservedDate, double duration,
			double time, String startTime) {
		super();
		this.strDate = strDate;
		this.room = room;
		this.patron = patron;
		this.reservedDate = reservedDate;
		this.duration = duration;
		this.time = time;
		this.startTime = startTime;
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

	public double getduration() {
		return duration;
	}

	public void setduration(double duration) {
		this.duration = duration;
	}
	
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "The room is "+room.getRoomNumber()+", and is being reserved by "+ patron.getName()+" on "+ reservedDate +".";
	}
	
	
}
