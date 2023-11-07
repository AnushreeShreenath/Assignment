package com.springboot.crud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeServiceImpl;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {
	    @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private EmployeeServiceImpl employeeService;

	    private Employee employee;

	    @BeforeEach
	    void setUp() {
	     employee = new Employee();
			employee.setEmployeeId(1L);
			employee.setName("Scott");
			employee.setEmail("scott@gmail.com");
			employee.setSalary(25000.0);
			employee.setDateOfJoining(Calendar.getInstance().getTime());
 	    }

	    @Test
	    void testSaveEmployee() throws Exception {
	        Mockito.when(employeeService.saveEmployee(employee))
	    		               .thenReturn(employee);

	        mockMvc.perform(post("/employee")
	        	.contentType(MediaType.APPLICATION_JSON)
	        	.content("{\r\n"
	        		+ "    \"empno\":\"1\",\r\n"
	        		+ "    \"name\":\"Scott\",\r\n"
	        		+ "    \"email\":\"scott@gmail.com\",\r\n"
	        		+ "    \"salary\":25000.0,\r\n"
	        		+ "    \"dateOfJoining\":\"2023-10-24\"\r\n"
	        		+ "}"))
	         	.andExpect(status().isOk());
	    }
	    
	       	    
	    @Test
	    void testGetEmployeeByById() throws Exception {
	        Mockito.when(employeeService.getEmployeeById(1L))
	                .thenReturn(employee);

	        mockMvc.perform(get("/employee/1")
	        .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());
	    }
	}
