package com.springboot.crud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.repository.EmployeeRepository;

@SpringBootTest
class EmployeeServiceImplTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() throws Exception {
		Employee employee = new Employee();
		employee.setEmployeeId(1L);
		employee.setName("Scott");
		employee.setEmail("scott@gmail.com");
		employee.setSalary(25000.0);
		employee.setDateOfJoining(Calendar.getInstance().getTime());

		Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
	}
	
        @Test
        @DisplayName("Find employee by ID")
        public void testGetEmployeeById() {
        long employeeId = 1L;
        Employee employeeFound = employeeService.getEmployeeById(employeeId);
        assertEquals(employeeId, employeeFound.getEmployeeId());
        assertEquals("Scott", employeeFound.getName());
    }
}
