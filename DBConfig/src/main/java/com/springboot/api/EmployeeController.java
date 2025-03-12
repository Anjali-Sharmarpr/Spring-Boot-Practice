package com.springboot.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	// get all employees

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> empList = new ArrayList<>();

		employeeRepository.findAll().forEach(empList::add);

		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

	// create employee

	@PostMapping("/employees")
	public String createEmployee(@RequestBody Employee employee) {

		employeeRepository.save(employee);

		return "Employee Added in the database";
	}

	// get employee by id

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.FOUND);
		} else {

			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	// return employee;

	// delete by id

	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id) {

		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee Deleted";
		} else {
			return "Employee id not found";
		}

	}

	// update by id

	@PutMapping("/employees/{empid}")
	public String updateEmployeeById(@PathVariable int empid, @RequestBody Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(empid);
		if (emp.isPresent()) {
			Employee existEmp = emp.get();
			existEmp.setName(employee.getName());
			existEmp.setAddress(employee.getAddress());
			existEmp.setEmailId(employee.getEmailId());

			employeeRepository.save(existEmp);
			return "Employee Details against Id " + empid + " updated";
		} else {
			return "Employee Details does not exist for empid " + empid;
		}
	}
}
