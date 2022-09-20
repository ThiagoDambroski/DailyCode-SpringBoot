package com.dambroski.Springboottutorial.service;

import java.util.List;

import com.dambroski.Springboottutorial.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartament();

	public Department fetchDepartamentById(Long departmentId);

	public void deleteDepartmentsById(Long departmentId);

}
