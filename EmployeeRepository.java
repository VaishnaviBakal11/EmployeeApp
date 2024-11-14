package com.Day2EmployeeProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Day2EmployeeProject.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value="select * from Employee where status= 'active' order by created_at DESC",nativeQuery = true)
	List <Employee> findAllOrderByCreatedAtDesc();
	

}
