package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@Repository //studentRepository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByemployeeEmail(String input);
}