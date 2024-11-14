package com.Day2EmployeeProject.Service;

import org.springframework.http.ResponseEntity;

import com.Day2EmployeeProject.Entity.EmpImage;
import com.Day2EmployeeProject.Entity.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	public ResponseEntity<Object> getAllEmployee();

	public ResponseEntity<Object> getEmployeeById(int id);

	public ResponseEntity<Object> saveEmployee(Employee emp);

	public ResponseEntity<Object> updateEmployee(Employee emp, int id);

	public ResponseEntity<Object> deleteEmployeeById(int id);

	public ResponseEntity<Object> addEmpImage(int empId, @Valid EmpImage emp);

}
