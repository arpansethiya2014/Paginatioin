package com.bean;

import java.sql.Timestamp;

public class Employee {

	private int id;
	private String name;
	private int salary;
	private String department;
	private Timestamp timestamp;

	public Employee() {
	}

	public Employee(int id, String name, int salary, String department, Timestamp timestamp) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
