package com.test.awss3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.awss3.entity.TestBean;
import com.test.awss3.repository.TestBeanDao;

@RestController
public class HomeController {
    @Autowired
    TestBeanDao dao;
    
	@GetMapping("/")
	public List<TestBean> getTestBean() {
		return dao.findAll();
	}
}
