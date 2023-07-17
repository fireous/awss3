package com.test.awss3.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "test")
public class TestBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 100)
	private Integer id;
    
	@Column(name = "picture", columnDefinition = "LONGTEXT")
	private String picture;
	
    public TestBean() {
    }

    public TestBean(String picture) {
        this.picture = picture;
    }
    
}
