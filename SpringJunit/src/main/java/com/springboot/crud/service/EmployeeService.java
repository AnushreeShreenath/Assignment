package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	public Employee getEmployeeById(long id);
	public List<Employee> getEmployees();
	public Employee updateEmployee(Employee emp);
	public void deleteEmployee(long id);

}
