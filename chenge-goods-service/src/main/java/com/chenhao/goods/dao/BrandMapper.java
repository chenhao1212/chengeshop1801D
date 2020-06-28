package com.chenhao.goods.dao;

import java.util.List;

import com.chenhao.goods.entity.Brand;

public interface BrandMapper {
	
	Brand findById(int id);
	
	List<Brand> queryAllBrand(Brand brand);
	
}
