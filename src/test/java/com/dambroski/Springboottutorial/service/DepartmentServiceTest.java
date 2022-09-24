package com.dambroski.Springboottutorial.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dambroski.Springboottutorial.entity.Department;
import com.dambroski.Springboottutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService service;
	
	@MockBean
	private DepartmentRepository repository;


	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder(
				).departmentName("IT").
				departmentAddress("brasil").
				departmentCode("IT-06").
				departmentId(1L).build();
		
		Mockito.when(repository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
	}
	
	@Test
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = service.fetchDepartmentByName(departmentName);
		
		assertEquals(departmentName, found);
		
	}

}
