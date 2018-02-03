package com.jja.entity;

import java.util.Date;

public class Users {
	
	public Users() {
		super();
	}

	public Users(Integer id, String username, String password, double salary) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salary = salary;
	}

	private Integer id;

	private Date birthday;

	private String username;
	
	private String password;
	
	private double salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", birthday=" + birthday + ", username=" + username + ", password=" + password
				+ ", salary=" + salary + "]";
	}

}

