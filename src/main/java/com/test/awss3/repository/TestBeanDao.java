package com.test.awss3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.awss3.entity.TestBean;

public interface TestBeanDao extends JpaRepository<TestBean, Integer>{
    
}
