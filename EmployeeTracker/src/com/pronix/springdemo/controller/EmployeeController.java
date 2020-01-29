package com.pronix.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pronix.springdemo.entity.Employee;
import com.pronix.springdemo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	//need to inject EmployeeService
	@Autowired
	private EmployeeService emplService;
	
	

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//Get employees from DAO
		
		List<Employee> theEmployee = emplService.getEmployees();
		
		//add employees to the model
		
		theModel.addAttribute("Employees", theEmployee);
		
		return "list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Employee theEmp = new Employee();
		
		theModel.addAttribute("adEmployee", theEmp);
		
		return "add-employee";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("adEmployee") Employee theEmployee) {
		
		emplService.saveEmployee(theEmployee);
		
		return "redirect:/employee/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("EmployeeId") int theId,Model theModel) {
		
		Employee theEmployee = emplService.getEmployee(theId);
		
		theModel.addAttribute("adEmployee", theEmployee);
		
		return "add-employee";
	}
	@GetMapping("/delete")
	public String DeleteForm(@RequestParam("EmployeeId") int theId,Model theModel) {
		
		Employee theEmployee = emplService.deleteEmployee(theId);
		
		
		return "redirect:/employee/list";
	}
	@GetMapping("/search")
	public String search(@RequestParam("theSearchName") String searchName,Model theModel) {
		
		List<Employee> theList = emplService.searchName(searchName);
		
		theModel.addAttribute("Employees", theList);
		
		return "list-employees";
	}
	
	
}
