package com.chenhao.goods.dao;

import java.util.List;

import com.chenhao.goods.entity.Category;

public interface CategoryMapper {
	int add(Category category);
	
	int update(Category category);
	
	int del(Integer id);
	
	List<Category> list(Integer parenId);
}
