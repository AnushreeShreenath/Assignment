package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.error.RecordNotFoundException;
import com.springboot.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employeeDb=employeeRepository.findById(id);
		
		if(employeeDb.isPresent())
		{
			Employee emp=employeeDb.get();
			return emp;
		}
		else
		{
			throw new RecordNotFoundException("Record not found");
		}
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();

	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> employeeDb=employeeRepository.findById(emp.getEmployeeId());
		
		if(employeeDb.isPresent())
		{
			Employee employeeUpdate=employeeDb.get();
			employeeUpdate.setEmail(emp.getEmail());
			employeeUpdate.setSalary(emp.getSalary());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		}
		else
		{
			throw new RecordNotFoundException("Record not found");
		}

	}

	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> employeeDb=employeeRepository.findById(id);
		
		if(employeeDb.isPresent())
		{
	         employeeRepository.delete(employeeDb.get());
		}
		else
		{
			throw new RecordNotFoundException("Record not found");
		}
	}

}
