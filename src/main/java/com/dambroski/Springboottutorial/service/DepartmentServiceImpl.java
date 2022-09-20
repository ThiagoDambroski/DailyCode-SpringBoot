package com.dambroski.Springboottutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.Springboottutorial.entity.Department;
import com.dambroski.Springboottutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	@Override
	public Department saveDepartment(Department department) {
		return repository.save(department);
	}

	@Override
	public List<Department> fetchDepartament() {
		return repository.findAll();
	}

	@Override
	public Department fetchDepartamentById(Long departmentId) {
		return repository.findById(departmentId).get();
	}

}
