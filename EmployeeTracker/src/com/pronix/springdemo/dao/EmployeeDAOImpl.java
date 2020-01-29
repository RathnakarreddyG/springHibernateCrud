package com.pronix.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.pronix.springdemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// Need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {

		// get hibernate session

		Session session = sessionFactory.getCurrentSession();

		// Create query

		Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);

		// execute query and get result list

		List<Employee> theEmployees = theQuery.getResultList();
		
		// return the results

		return theEmployees;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theEmployee);
		
	}

	@Override
	public Employee getEmployee(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Employee theEmp = session.get(Employee.class, theId);
		
		return theEmp;
	}

	@Override
	public Employee deleteEmployee(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Employee theEmp = session.get(Employee.class, theId);
		session.delete(theEmp);
		return theEmp;
	}

	@Override
	public List<Employee> searchName(String searchName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		if(searchName != null && searchName.trim().length()>0) {
			
			theQuery = session.createQuery
					("from Employee where lower(first_name) like :theName or lower(last_name) like :theName",Employee.class);
			theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");
 		}else {
 			//If search is empty display all employees
 			
 			theQuery = session.createQuery("from Employee",Employee.class);
 			
 		}
		List<Employee> theList = theQuery.getResultList();
		
		return theList;
	}

}
