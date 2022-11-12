package com.example.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.entity.Department;
import com.example.department.repo.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		log.info("inside savedepartment method of departmentservice");
		return departmentRepository.save(department);
	}

	public Optional<Department> findDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		log.info("inside finddepartment method of departmentservice");
		return departmentRepository.findById(departmentId);
	}

	public List<Department> getAllDepartments() {
		log.info("inside getalldepartment method of departmentservice");
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	public Department updateDepartment(Long departmentId,Department oldDepartment) {
		// TODO Auto-generated method stub
		log.info("inside updatedepartment method of departmentservice");
		Department newdepartment=departmentRepository.findById(departmentId).get();
		newdepartment.setDepartmentName(oldDepartment.getDepartmentName());
		newdepartment.setDepartmentAddress(oldDepartment.getDepartmentAddress());
		newdepartment.setDepartmentCode(oldDepartment.getDepartmentCode());	
		log.info("values are set to the pojo");
		return departmentRepository.save(newdepartment);
	}

	public Boolean deleteById(Long departmentId) {
		// TODO Auto-generated method stub
		if(departmentRepository.findById(departmentId).isPresent()) {
		log.info("inside deletedepartment method of departmentservice");
		    departmentRepository.deleteById(departmentId);		
			return true;
		}
			else
				return false;

		
	}

}
