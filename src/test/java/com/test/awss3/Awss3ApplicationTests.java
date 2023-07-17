package com.test.awss3;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.awss3.entity.TestBean;
import com.test.awss3.jsonBean.DishJson;
import com.test.awss3.jsonBean.reader.ReadJson;
import com.test.awss3.repository.TestBeanDao;
import com.test.awss3.service.PictureUploadService;

@SpringBootTest
class Awss3ApplicationTests {
	@Autowired
	private PictureUploadService service;

    @Autowired
    private TestBeanDao dao;

	@Test
	void contextLoads() {
        try {            
            List<DishJson> json = getJson("/static/json/dish.json", DishJson.class);
            for(DishJson dish : json){
                String img64 = dish.picture;
                String[] parts = img64.split(",");
                if (parts.length > 1) {
                    img64 = parts[1];
                }
                String url = service.uploadBase64Image(img64);
                TestBean bean = new TestBean(url);
                dao.save(bean);
                // System.out.println(url);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
	}


    public <T> List<T> getJson(String jsonPath, Class<T> type) throws Exception {
        String jsonStr = ReadJson.getJsonFileString(jsonPath);
        List<T> json = new LinkedList<>();
        
        if (jsonStr != null) {
            Type listType = TypeToken.getParameterized(List.class, type).getType();
            json = new Gson().fromJson(jsonStr, listType);
        } else {
            return null;
        }
        return json;
    }
}
