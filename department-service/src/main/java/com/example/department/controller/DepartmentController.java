package com.example.department.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside save department method of DepartmentController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/{departmentId}")
	public Optional<Department> findDepartmentById(@PathVariable Long departmentId) {
		log.info("Inside finddepartment method of DepartmentController");
		return departmentService.findDepartmentById(departmentId);
	}
	
	@GetMapping("/")
	public  List<Department> getDepartments(){
		log.info("Inside getalldepartment method of DepartmentController");
		return departmentService.getAllDepartments();
	}
	
	@PutMapping("/{departmentId}")
	public Department updateById(@PathVariable Long departmentId,@RequestBody Department newDepartment) {
		log.info("Inside updatedepartment method of DepartmentController");
		return departmentService.updateDepartment(departmentId,newDepartment);
	}
	
	@DeleteMapping("/{departmentId}")
	public String deleteById(@PathVariable Long departmentId) {
		log.info("Inside deletedepartment method of DepartmentController");
		departmentService.deleteById(departmentId);
		return "deleted" + departmentId;
	}
	
}
