package com.dambroski.Springboottutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.dambroski.Springboottutorial.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		
		Department department = Department.builder()
				.departmentName("medical")
				.departmentCode("ME - 011") 
				.departmentAddress("PE").build();
		
		entityManager.persist(department);
	}
	@Test
	public void whenFindById_thenReturnDepartment() {
		Department department = departmentRepository.findById(1L).get();
	
		assertEquals(department.getDepartmentName(), "medical");
	}

	

}
