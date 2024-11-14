package com.Day2EmployeeProject.Entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class EmpImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String imageUrl;

	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee emp;

}
