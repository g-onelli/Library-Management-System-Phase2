package com.springboot.backend.dto;

public class LibrarianIdDto {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LibrarianIdDto [id=" + id + "]";
	}

	public LibrarianIdDto(Integer id) {
		super();
		this.id = id;
	}

	public LibrarianIdDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
