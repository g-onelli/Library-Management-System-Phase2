package com.springboot.backend.dto;

import java.time.LocalDate;

public class RequestDto {
	private Integer id;
	private String description;
	private LocalDate submissiondate;
	private String title;
	private String author;
	private Integer pid;
	private String pname;
	private Integer tpages;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getSubmissiondate() {
		return submissiondate;
	}
	public void setSubmissiondate(LocalDate submissiondate) {
		this.submissiondate = submissiondate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getTpages() {
		return tpages;
	}
	public void setTpages(Integer tpages) {
		this.tpages = tpages;
	}
	@Override
	public String toString() {
		return "RequestDto [id=" + id + ", description=" + description + ", submissiondate=" + submissiondate
				+ ", title=" + title + ", author=" + author + ", pid=" + pid + ", pname=" + pname + ", tpages=" + tpages
				+ "]";
	}
	
	
	
}
