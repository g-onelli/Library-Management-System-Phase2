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
@Table(name = "fees")
public class Fee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	
	@Column(length = 45, nullable = false)
	private double total;
	
	@Column(nullable = true)
	private LocalDate datePaid;
	
	@Column(length = 45, nullable = true)
	private String feeType;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Patron patron;

	public Fee(Integer id, double total, LocalDate datePaid, String feeType, Patron patron) {
		super();
		this.id = id;
		this.total = total;
		this.datePaid = datePaid;
		this.feeType = feeType;
		this.patron = patron;
	}

	public Fee() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "Fee [id=" + id + ", total=" + total + ", datePaid=" + datePaid + ", feeType=" + feeType + ", patron="
				+ patron + "]";
	}
	
	
}
