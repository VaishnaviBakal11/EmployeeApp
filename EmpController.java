package com.Day2EmployeeProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Day2EmployeeProject.Entity.EmpImage;
import com.Day2EmployeeProject.Entity.Employee;
import com.Day2EmployeeProject.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class EmpController {
	@Autowired
	private EmployeeService empservice;

	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllEmployee() {
		return empservice.getAllEmployee();
	}

	@GetMapping("/getEmployee/{Id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable int Id) {
		return empservice.getEmployeeById(Id);
	}

	@PostMapping("/saveEmployee")
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee emp) {
		return empservice.saveEmployee(emp);
	}

	@PutMapping("/updateEmployee/{Id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp, @PathVariable int Id) {
		return empservice.updateEmployee(emp, Id);
	}

	@DeleteMapping("/deleteEmployee/{Id}")
	public ResponseEntity<Object> deleteEmployeeById(@PathVariable int Id) {
		return empservice.deleteEmployeeById(Id);
	}

	@PostMapping("/addEmpImage/{empId}")
	public ResponseEntity<Object> addEmpImage(@PathVariable int empId, @Valid @RequestBody EmpImage emp) {
		return empservice.addEmpImage(empId, emp);
	}

}
