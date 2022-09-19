package com.dambroski.Springboottutorial.service;

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

}
