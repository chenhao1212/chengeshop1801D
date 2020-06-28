package com.chenhao.goods.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenhao.goods.dao.BrandMapper;
import com.chenhao.goods.entity.Brand;
import com.chenhao.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandMapper mapper;
	
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PageInfo<Brand> list(Brand brand) {
		PageHelper.startPage(1, 10);
		return new PageInfo<Brand>(mapper.queryAllBrand(brand));
	}

	public Brand getById(int id) {
		return mapper.findById(id);
	}

}
