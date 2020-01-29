package com.pronix.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pronix.springdemo.dao.EmployeeDAO;
import com.pronix.springdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//Injecting Employee DAO
	
	@Autowired
	private EmployeeDAO empDAO;
	
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		
		return empDAO.getEmployees();
	}


	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		
		empDAO.saveEmployee(theEmployee);
	}


	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		
		return empDAO.getEmployee(theId);
	}


	@Override
	@Transactional
	public Employee deleteEmployee(int theId) {
		
		return empDAO.deleteEmployee(theId);
	}


	@Override
	@Transactional
	public List<Employee> searchName(String searchName) {
		
		return empDAO.searchName(searchName);
	}

}
