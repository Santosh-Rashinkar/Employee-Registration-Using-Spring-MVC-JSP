package com.prowings.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prowings.dao.EmployeeDao;
import com.prowings.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	
//	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@PostMapping("/save")
	public String addEmployee(HttpServletRequest model)
	{
		System.out.println("inside addEmployee() in EmployeeController!!!!");

		String name    = (String) model.getParameter("name");
		String address = (String) model.getParameter("address");
		
		Employee employee = new Employee(name, address);
		
		System.out.println("incoming employee model : "+employee);
		
		//call to DAO logic to save incoming employee
		employeeDao.saveEmployee(employee);
		
		return "savedSuccess";
	}

	@GetMapping("/list")
	public String getEmployeesList(Model model) {

		System.out.println("inside getEmployeesList() method of EmployeeController");

		List<Employee> empList = employeeDao.getEmployeesList();

		System.out.println(empList);
		
		model.addAttribute("employees",empList);
			
		return "listEmployee";		
	}
	
}
