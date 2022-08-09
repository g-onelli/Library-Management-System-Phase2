package com.springboot.backend.dto;

public class PatronIdDto {
	private Integer id;
	private String name;
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
	@Override
	public String toString() {
		return "PatronIdDto [id=" + id + ", name=" + name + "]";
	}
	public PatronIdDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public PatronIdDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
