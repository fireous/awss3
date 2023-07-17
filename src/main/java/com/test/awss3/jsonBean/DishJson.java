package com.test.awss3.jsonBean;

import java.util.Map;

public class DishJson {
	public Integer id;
	public String name;
	public Map<String,Object> categoryBean;
	public String picture;
	public Integer price;
	public Integer cost;
	public String description;
	public String status;

	public DishJson(Integer id, String name, Map<String, Object> categoryBean, String picture, Integer price,
			Integer cost, String description, String status) {
		this.id = id;
		this.name = name;
		this.categoryBean = categoryBean;
		this.picture = picture;
		this.price = price;
		this.cost = cost;
		this.description = description;
		this.status = status;
	}	
}
