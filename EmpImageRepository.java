package com.Day2EmployeeProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Day2EmployeeProject.Entity.EmpImage;

@Repository
public interface EmpImageRepository extends JpaRepository<EmpImage, Long> {

}
