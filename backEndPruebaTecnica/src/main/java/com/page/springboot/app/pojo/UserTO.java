package com.page.springboot.app.pojo;

public class UserTO {

	private int userId;

	private boolean complited;

	private int id;

	private String title;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isComplited() {
		return complited;
	}

	public void setComplited(boolean complited) {
		this.complited = complited;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
