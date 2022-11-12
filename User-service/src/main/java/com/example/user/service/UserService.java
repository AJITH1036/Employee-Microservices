package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
		log.info("inside save user method of user service");
		return repo.save(user);
	}

	
	public ResponseTemplateVO getUserWithDepartment(Long userId) {	
		ResponseTemplateVO vo= new ResponseTemplateVO();
		User user =  repo.findByUserId(userId);		
		Department department = 
				restTemplate.getForObject("http://localhost:8080/departments/" + user.getDepartmentId(), Department.class);		
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
	
	

}
