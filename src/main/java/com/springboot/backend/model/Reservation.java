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
	private String reserveDate;
	
	@Column 
	private double reservedHr;
	
	@Column
	private int reservedTime;
	
	public Reservation() {
		super();
	}

	public Reservation(Integer id, String reserveDate, double reservedHr, int reservedTime) {
		super();
		this.id = id;
		this.reserveDate = reserveDate;
		this.reservedHr = reservedHr;
		this.reservedTime = reservedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public double getReservedHr() {
		return reservedHr;
	}

	public void setReservedHr(Double reservedHr) {
		this.reservedHr = reservedHr;
	}

	public int getReservedTime() {
		return reservedTime;
	}

	public void setReservedTime(Integer reservedTime) {
		this.reservedTime = reservedTime;
	}

	public double endBoundary() {
		double time = reservedHr + reservedTime;
		if(time>25) {
			time = time-24;
		}
		return time;
	}
	
	public boolean reserveEquals(Reservation reserve) {
		if(this.reserveDate != reserve.reserveDate) {
			return false;
		}
		Double oldDate = this.endBoundary();
		Double newDate = reserve.endBoundary();
		if(reserve.reservedHr==this.reservedHr || (newDate>=this.reservedHr & newDate<=oldDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reserveDate=" + reserveDate + ", reservedHr=" + reservedHr
				+ ", reservedTime=" + reservedTime + "]";
	}
	
}
