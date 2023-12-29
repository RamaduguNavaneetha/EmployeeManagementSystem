package com.example.demo.entity;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicUpdate
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column(nullable = false)
	private String employeeName;
	private Long employeeMobile;
	private Integer employeeSalary;
	@Column(unique = true, nullable = false)
	private String employeeEmail;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getEmployeeMobile() {
		return employeeMobile;
	}
	public void setEmployeeMobile(Long employeeMobile) {
		this.employeeMobile = employeeMobile;
	}
	public Integer getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public Employee(int employeeId, String employeeName, Long employeeMobile, Integer employeeSalary,
			String employeeEmail) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeMobile = employeeMobile;
		this.employeeSalary = employeeSalary;
		this.employeeEmail = employeeEmail;
	}
	public Employee() {
	
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeMobile="
				+ employeeMobile + ", employeeSalary=" + employeeSalary + ", employeeEmail=" + employeeEmail + "]";
	}
	
	
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmailId() {
//		return emailId;
//	}
//	public Employee(String name,  Integer salary,String emailId) {
//		this.name = name;
//		this.salary = salary;
//		this.emailId = emailId;
//	}
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//
//	public Employee(){
//
//	}
//	public Integer getSalary() {
//		return salary;
//	}
//	public void setSalary(Integer salary) {
//		this.salary = salary;
//	}

}

