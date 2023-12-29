package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeePerformance;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.transaction.Transactional;

@Service // buisness logic, bean --> studentServiceImpl
@Transactional
public class EmployeeServiceImpl implements EmployeePerformance {
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmployeeRepository empRepo;
	private String str;

	public Employee addEmployeeDetails(Employee employeeObj) {
		// save or persis
		return empRepo.save(employeeObj);
	}

	public List<Employee> readAllEmployeesFromDb() {
		System.out.println("EmployeeService");
		return empRepo.findAll();
	}

	public Employee readEmployeeFromDb(int employeeId) {
		Optional<Employee> employeeObjFromDb = empRepo.findById(employeeId); // select * from tn where id =
		if (employeeObjFromDb.get() != null) // matching primary key is there
			return employeeObjFromDb.get();
		else
			return new Employee();
	}

	public void deleteEmployeeById(int deleteId) {
		Optional<Employee> employeeObjFromDb = empRepo.findById(deleteId);
		if (employeeObjFromDb.get() != null)
			str = OtpGeneratorImpl.generateOtp();
		PhoneNumber to = new PhoneNumber("+919704076965");
		PhoneNumber from = new PhoneNumber("+12057725432");
		String otpMessage = "Dear Customer , Your OTP is  " + str
				+ " for sending sms through Spring boot application. Thank You.";
		Message message = Message.creator(to, from, otpMessage).create();
		empRepo.deleteById(deleteId);
	}

	public void deleteEmployees() {

		empRepo.deleteAll();
	}

	/*
	 * public void updateEmployeeDetails(int id, Employee newvalue) {
	 * 
	 * Optional<Employee> employeeObjFromDb = empRepo.findById(id); if
	 * (employeeObjFromDb.get() != null) { Employee existingEmpDetails =
	 * employeeObjFromDb.get();
	 * existingEmpDetails.setEmployeeEmail(newvalue.getEmployeeEmail());
	 * existingEmpDetails.setEmployeeName(newvalue.getEmployeeName());
	 * existingEmpDetails.setEmployeeSalary(newvalue.getEmployeeSalary());
	 * existingEmpDetails.setEmployeeMobile(newvalue.getEmployeeMobile());
	 * 
	 * 
	 * empRepo.save(existingEmpDetails); //
	 * emailService.sendEmail(newvlue.getEmailId(), "check",
	 * "New details are updated...!!!!"+newvlue.getEmailId());
	 * emailService.sendEmail("buddinandini@gmail.com", "check",
	 * "New details are updated...!!!!" +
	 * newvalue.getEmployeeSalary()+newvalue.getEmployeeName()+newvalue.
	 * getEmployeeEmail() + newvalue.getEmployeeMobile() ); } }
	 */

	public void updateEmployeeDetails(Employee newvalue) {

		empRepo.save(newvalue);
//			emailService.sendEmail(newvlue.getEmailId(), "check", "New details are updated...!!!!"+newvlue.getEmailId());
		emailService.sendEmail("buddinandini@gmail.com", "check",
				"New details are updated...!!!!" + newvalue.getEmployeeSalary() + newvalue.getEmployeeName()
						+ newvalue.getEmployeeEmail() + newvalue.getEmployeeMobile());
	}

	@Override
	public List<Employee> readAllEmployeeFromDb() {
		// TODO Auto-generated method stub
		return null;
	}
}