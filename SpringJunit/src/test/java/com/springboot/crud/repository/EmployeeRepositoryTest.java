package com.springboot.crud.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.crud.entity.Employee;

@SpringBootTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() {
		Employee employee = new Employee();
		employee.setEmployeeId(1L);
		employee.setName("Scott");
		employee.setEmail("scott@gmail.com");
		employee.setSalary(25000.0);
		employee.setDateOfJoining(Calendar.getInstance().getTime());

		employeeRepository.save(employee);
	}

	//@Disabled
	@Test
	public void testSaveEmployee() {

		Employee employee = new Employee();
		employee.setEmployeeId(1L);
		employee.setName("Rose");
		employee.setEmail("rose@gmail.com");
		employee.setSalary(35000.0);
		employee.setDateOfJoining(Calendar.getInstance().getTime());

		Employee savedEmployee=employeeRepository.save(employee);

		assertThat(savedEmployee).hasFieldOrPropertyWithValue("name", "Rose");
		assertThat(savedEmployee).hasFieldOrPropertyWithValue("email", "rose@gmail.com");
		assertThat(savedEmployee).hasFieldOrPropertyWithValue("salary", 35000.0);
	}

	@Disabled
	@Test
	public void testFindEmployeeById() {
		Employee employee = employeeRepository.findById(1L).get();
		assertEquals("Scott",employee.getName());
	}

	@Disabled
	@Test
	public void testFindAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		assertTrue(employees.size() == 1);
	}
	
	@Disabled
	 @Test
	  public void testUpdateEmployeeById() {
	    Employee employeeToUpdate = employeeRepository.findById(1L).get();
	    employeeToUpdate.setEmployeeId(1L);
	    employeeToUpdate.setEmail("scott.clinton@gmail.com");
	    employeeToUpdate.setSalary(99999);
	    employeeRepository.save(employeeToUpdate);
	    Employee employeeUpdated = employeeRepository.findById(1L).get();
	    
	    assertThat(employeeUpdated.getEmployeeId()).isEqualTo(employeeToUpdate.getEmployeeId());
	    assertThat(employeeUpdated.getName()).isEqualTo(employeeToUpdate.getName());
	    assertThat(employeeUpdated.getEmail()).isEqualTo(employeeToUpdate.getEmail());
	   // assertThat(employeeUpdated.getSalary()).isEqualTo(employeeToUpdate.getSalary());
	    assertThat(employeeUpdated.getSalary()).isEqualTo(employeeToUpdate.getSalary());
	  }
	 
	
	@Disabled
	@Test
	  public void testDeleteEmployeeById() {
	    employeeRepository.deleteById(1L);
	    assertEquals(true,employeeRepository.findById(1L).isEmpty());
	  }
}
