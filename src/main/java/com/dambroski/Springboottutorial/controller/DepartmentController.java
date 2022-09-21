package com.dambroski.Springboottutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dambroski.Springboottutorial.entity.Department;
import com.dambroski.Springboottutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		return service.saveDepartment(department);
		
	}
	
	
	@GetMapping("/departments")
	public List <Department> fetchDepartament() {
		return service.fetchDepartament();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartamentById(@PathVariable("id") Long DepartmentId) {
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
