package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.EmployeePerformance;

@Service

public class UserServiceImpl implements EmployeePerformance{

	@Autowired
	private UserRepository userRepository;


	public void addUser(User user) {

		this.userRepository.save(user);  

	}


	public Optional<User> getUserByEmail(String email) {

		return this.userRepository.findByuserEmail(email);

	}


	@Override
	public Employee addEmployeeDetails(Employee employeeObj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Employee> readAllEmployeeFromDb() {
		// TODO Auto-generated method stub
		return null;
	}
}



