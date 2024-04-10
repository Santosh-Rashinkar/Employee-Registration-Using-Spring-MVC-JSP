package com.prowings.dao;

import java.util.List;

import com.prowings.entity.Employee;

public interface EmployeeDao {

	public boolean saveEmployee(Employee employee);
	
	public List<Employee> getEmployeesList();
		
}
