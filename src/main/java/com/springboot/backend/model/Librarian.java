package com.springboot.backend.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "librarians")
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private Integer id;
	@Column(length = 45, nullable = true)
    private String name;
	
	@Column(nullable = true)
    private Double salary;
	
	@Column(length = 45, nullable = true)
    private String position;
	
	@Column(length = 45, nullable = true)
    private String email;
	
	@Column(length = 10, nullable = true)
    private String phonenumber;
	@OneToOne(cascade = {CascadeType.ALL})
	private UserInfo userinfo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	@Override
	public String toString() {
		return "Librarian [id=" + id + ", name=" + name + ", salary=" + salary + ", position=" + position + ", email="
				+ email + ", phonenumber=" + phonenumber + ", userinfo=" + userinfo + "]";
	}
	public Librarian(Integer id, String name, Double salary, String position, String email, String phonenumber,
			UserInfo userinfo) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.email = email;
		this.phonenumber = phonenumber;
		this.userinfo = userinfo;
	}
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}

}
