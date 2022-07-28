package com.springboot.backend.dto;

import java.time.LocalDate;

import com.springboot.backend.model.Patron;

public class FeeDto {
	private Integer id;
	private double total;
	private LocalDate datePaid;
	private String feeType;
	private Patron patron;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDate getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(LocalDate datePaid) {
		this.datePaid = datePaid;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public Patron getPatron() {
		return patron;
	}
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	
}
