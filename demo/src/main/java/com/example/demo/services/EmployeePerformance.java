package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeePerformance {
	Employee addEmployeeDetails(Employee employeeObj);
	List<Employee> readAllEmployeeFromDb();
	
	
}
