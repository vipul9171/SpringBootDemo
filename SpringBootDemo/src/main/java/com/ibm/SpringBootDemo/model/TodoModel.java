package com.ibm.SpringBootDemo.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class TodoModel {

	public TodoModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String user;

	@Size(min = 10, message = "Please enter at least 10 character")
	private String desc;
	private Date targetDate;
	private boolean isDone;

	@Override
	public String toString() {
		return "LoginModel [id=" + id + ", user=" + user + ", desc=" + desc + ", targetDate=" + targetDate + ", isDone="
				+ isDone + "]";
	}

	public TodoModel(int id, String user, String desc, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoModel other = (TodoModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	

}
