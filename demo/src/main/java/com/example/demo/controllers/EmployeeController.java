package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.serviceImpl.EmployeeServiceImpl;

@RestController // controller + response body , accepts request , returns respon
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeImpl;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	@PutMapping("/employee")
	void updateEmployeeDetails(@RequestBody Employee newvalue) {
		employeeImpl.updateEmployeeDetails(newvalue);
		
	}
	@DeleteMapping("/employee/{id}")
	void deleteEmployee(@PathVariable("id") int id) {
		employeeImpl.deleteEmployeeById(id);
	}

	@DeleteMapping
	void deleteAllEmployee() {
		employeeImpl.deleteEmployees();
	}

	@GetMapping("/employee/{id}")
	// @ResponseBody
	Employee readByEmployeeId(@PathVariable int id) {
		return employeeImpl.readEmployeeFromDb(id);
	}

	@GetMapping("/employee")
	ResponseEntity<?> getAllEmployeesFromDb() {
		List<Employee> employees = empRepo.findAll();
		
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping("/employee")
	Employee addEmployeeToDb(@RequestBody Employee employeeObj) {
		return employeeImpl.addEmployeeDetails(employeeObj);
	}
}