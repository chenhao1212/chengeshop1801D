package com.chenhao.goods.service;

import com.chenhao.goods.entity.Brand;
import com.github.pagehelper.PageInfo;

public interface BrandService {
	
	int add(Brand brand);
	
	
	int update(Brand brand);
	
	int delete(int []ids);
	
	PageInfo<Brand> list(Brand brand);
	
	Brand getById(int id);
}
