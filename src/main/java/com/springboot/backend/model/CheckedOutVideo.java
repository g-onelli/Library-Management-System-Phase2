package com.springboot.backend.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "checkedoutvideos")
public class CheckedOutVideo{
	@Id
	private int patrons_id;
	@Id
    private int videos_id;
    @Column
    private LocalDate dueDate;

    public CheckedOutVideo() {
        super();
    }

    public CheckedOutVideo(int patrons_id, int videos_id, LocalDate dueDate) {
        super();
        this.patrons_id = patrons_id;
        this.videos_id = videos_id;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "checkedOutVideo [patrons_id=" + patrons_id + ", videos_id=" + videos_id + ", dueDate="
                + dueDate + "]";
    }

    public int getPatrons_id() {
        return patrons_id;
    }

    public void setPatrons_id(int patrons_id) {
        this.patrons_id = patrons_id;
    }

    public int getVideos_id() {
        return videos_id;
    }

    public void setVideos_id(int videos_id) {
        this.videos_id = videos_id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate date) {
        this.dueDate = date;
    }

}
