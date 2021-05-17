package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entites.Department;
import com.capgemini.entites.Employee;
import com.capgemini.repository.DepartmentRepository;
import com.capgemini.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
    @Autowired
	private EmployeeRepository employeeRepository;
    
    @Autowired
     private DepartmentRepository departmentRepository;
    
    @GetMapping("/")
    public List<Employee> getEmployee() {
    	return employeeRepository.findAll();
    	
    }
    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
    	return employeeRepository.findById(id).get();
    }
  
    @PostMapping("/")
	public String createEmployee(@RequestBody Employee employee) {
    	
    	if(employee.getDepartment() != null) {
			Department dbDpartment =  departmentRepository.findById(employee.getDepartment().getId()).get();
			employee.setDepartment(dbDpartment);
		}
    	
		employeeRepository.save(employee);
		return "Employee Created!";
	}
    
    
}
