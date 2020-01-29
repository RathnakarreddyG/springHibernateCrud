package com.pronix.springdemo.service;

import java.util.List;

import com.pronix.springdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public Employee deleteEmployee(int theId);

	public List<Employee> searchName(String searchName);

}
