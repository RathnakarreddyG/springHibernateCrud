package com.pronix.springdemo.dao;

import java.util.List;

import com.pronix.springdemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public Employee deleteEmployee(int theId);

	public List<Employee> searchName(String searchName);
	
}
