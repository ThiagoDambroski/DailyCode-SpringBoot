package com.dambroski.Springboottutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.Springboottutorial.entity.Department;
import com.dambroski.Springboottutorial.erro.DepartmentNotFoundException;
import com.dambroski.Springboottutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("inside saveDepartment of DepartmentController");
		return service.saveDepartment(department);
		
	}
	
	
	@GetMapping("/departments")
	public List <Department> fetchDepartament() {
		LOGGER.info("inside fetchDepartament of DepartmentController");
		return service.fetchDepartament();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartamentById(@PathVariable("id") Long DepartmentId) throws DepartmentNotFoundException {
		return service.fetchDepartamentById(DepartmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentsById(@PathVariable("id") Long DepartmentId) {
		service.deleteDepartmentsById(DepartmentId);
		return "Delete successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id")Long departmentId, @RequestBody Department department) {
		
		return service.updateDepartment(departmentId,department);
	}
	
	@GetMapping("departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		
		return service.fetchDepartmentByName(departmentName);
	}
	
	

}
