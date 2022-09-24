package com.dambroski.Springboottutorial.service;

import java.util.List;

import com.dambroski.Springboottutorial.entity.Department;
import com.dambroski.Springboottutorial.erro.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartament();

	public Department fetchDepartamentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentsById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
