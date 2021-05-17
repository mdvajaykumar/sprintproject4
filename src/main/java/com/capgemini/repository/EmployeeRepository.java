package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
