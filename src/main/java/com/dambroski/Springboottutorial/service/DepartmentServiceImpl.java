package com.dambroski.Springboottutorial.service;

import java.util.List;
import java.util.Objects;

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

	@Override
	public void deleteDepartmentsById(Long departmentId) {
		repository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department newData = repository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName())&&
				!"".equals(department.getDepartmentName())) {
			newData.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode())&&
				!"".equals(department.getDepartmentCode())) {
			newData.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&&
				!"".equals(department.getDepartmentAddress())) {
			newData.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		return repository.save(newData);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return repository.findByDepartmentName(departmentName);
	}

}
