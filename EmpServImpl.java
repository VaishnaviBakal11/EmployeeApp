package com.Day2EmployeeProject.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Day2EmployeeProject.Entity.EmpImage;
import com.Day2EmployeeProject.Entity.Employee;
import com.Day2EmployeeProject.Exception.ResourceNotFoundException;
import com.Day2EmployeeProject.Repository.EmpImageRepository;
import com.Day2EmployeeProject.Repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class EmpServImpl implements EmployeeService {
	Map<Object, Object> response;

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private EmpImageRepository empImageRepository;

	@Override
	public ResponseEntity<Object> getAllEmployee() {
		List<Employee> data = empRepository.findAllOrderByCreatedAtDesc();
		response = new HashMap<>();
		if (data == null || data.isEmpty()) {
			response.put("status", "Failed");
			response.put("message", "Employee not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		} else {
			response.put("employeeDetails", data);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@Override
	public ResponseEntity<Object> getEmployeeById(int id) {
		Employee data = empRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with the id " + id + " not found"));
		response = new HashMap<>();

		response.put("employeeDetails", data);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@Override
	public ResponseEntity<Object> saveEmployee(Employee emp) {
		response = new HashMap<>();
//		if (emp.getName() == null || emp.getName().isEmpty() || emp.getName().isBlank()) {
//			response.put("Status", "failed");
//			response.put("Message", "Nmae is empty");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		// }
//		if (emp.getAddress() == null || emp.getAddress().isEmpty() || emp.getAddress().isBlank()) {
//			response.put("Status", "failed");
//			response.put("message", "Address is empty");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		}
//		if (emp.getEmail() == null || emp.getEmail().isEmpty() || emp.getEmail().isBlank()) {
//			response.put("status", "failed");
//			response.put("message", "Email is empty");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		}
//		if (emp.getStatus() == null || emp.getStatus().isBlank() || emp.getStatus().isEmpty()) {
//			response.put("Status", "failed");
//			response.put("message", "status is empty");
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		}
		emp.setStatus("active");
		Employee savedEmployee = empRepository.save(emp);
		response = new HashMap<>();
		response.put("status", "Success");
		response.put("message", "Employee created successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<Object> updateEmployee(Employee updatedEmployee, int id) {
		Optional<Employee> emp1 = empRepository.findById(id);
		response = new HashMap<>();
		if (emp1.isEmpty()) {
			response.put("Status", "Failed");
			response.put("Message", "Id Not Found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		} else {
			if (updatedEmployee.getEmail() == null || updatedEmployee.getEmail().isEmpty()
					|| updatedEmployee.getEmail().isBlank()) {
				emp1.get().setEmail(emp1.get().getEmail());
			} else {
				emp1.get().setEmail(updatedEmployee.getEmail());
			}
//			if (updatedEmployee.getName() == null || updatedEmployee.getName().isEmpty()
//					|| updatedEmployee.getName().isBlank()) {
//				emp1.get().setName(emp1.get().getName());
//			} else {
//				emp1.get().setName(updatedEmployee.getName());
//			}
			if (updatedEmployee.getAddress() == null || updatedEmployee.getAddress().isBlank()
					|| updatedEmployee.getAddress().isEmpty()) {
				emp1.get().setAddress(emp1.get().getAddress());
			} else {
				emp1.get().setAddress(updatedEmployee.getAddress());

			}
			if (updatedEmployee.getStatus() == null || updatedEmployee.getStatus().isBlank()
					|| updatedEmployee.getStatus().isEmpty()) {
				emp1.get().setStatus(emp1.get().getStatus());
			} else {
				emp1.get().setStatus(updatedEmployee.getStatus());
			}
			empRepository.save(emp1.get());

			response.put("Status", "Success");
			response.put("Message", "Employee Updated");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

	}

	@Override
	public ResponseEntity<Object> deleteEmployeeById(int id) {
		Optional<Employee> emp = empRepository.findById(id);
		if (emp.isEmpty()) {
			response = new HashMap<>();
			response.put("status", "failed");
			response.put("message", "Employee not found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		} else {
			empRepository.deleteById(id);
			response = new HashMap<>();
			response.put("status", "success");
			response.put("message", "employee found");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

		}
	}

	@Override
	public ResponseEntity<Object> addEmpImage(int empId, @Valid EmpImage emp) {
		response = new HashMap<>();
		Employee data = empRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with the id " + empId + " not found"));
		EmpImage ob = new EmpImage();
		ob.setImageUrl(emp.getImageUrl());
		ob.setEmp(data);
		empImageRepository.save(ob);
		response.put("status", "success");
		response.put("message", "Image stored successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

}
