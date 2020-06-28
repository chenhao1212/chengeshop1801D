package com.chenhao.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenhao.goods.entity.Category;
import com.chenhao.goods.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	@Reference
	private CategoryService service;
	
	@RequestMapping("index")
	public String index(Model m) {
		return "category/index";
	}
	@ResponseBody
	@RequestMapping("data")
	public List<Category> getDta(){
		return service.list(0);
	}
	
	@ResponseBody
	@RequestMapping("addCategory")
	public boolean addCategory(Category category) {
		
		return service.add(category)>0;
	}
	
	@ResponseBody
	@RequestMapping("updateCategory")
	public boolean updateCategory(Category category) {
		
		return service.update(category)>0;
	}
	
	@ResponseBody
	@RequestMapping("delCategory")
	public boolean delCategory(Category category) {
		return service.del(category.getParentId())>0;
	}
	
}
