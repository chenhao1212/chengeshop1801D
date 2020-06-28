package com.chenhao.goods.service;

import java.util.List;

import com.chenhao.goods.entity.Category;

public interface CategoryService {
	int add(Category category);
	
	int update(Category category);
	
	int del(Integer id);
	
	List<Category> list(Integer parenId);
	
}
