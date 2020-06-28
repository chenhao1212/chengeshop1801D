package com.chenhao.goods.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenhao.goods.dao.CategoryMapper;
import com.chenhao.goods.entity.Category;
import com.chenhao.goods.service.CategoryService;
@Service(interfaceClass = CategoryService.class)
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper mapper;
	
	
	@Override
	public int add(Category category) {
		
		return mapper.add(category);
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return mapper.update(category);
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return mapper.del(id);
	}

	@Override
	public List<Category> list(Integer parenId) {
		return mapper.list(parenId);
	}

}
