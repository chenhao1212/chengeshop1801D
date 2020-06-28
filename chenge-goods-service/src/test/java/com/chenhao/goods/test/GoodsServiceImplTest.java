package com.chenhao.goods.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenhao.goods.dao.BrandMapper;
import com.chenhao.goods.dao.SpecMapper;
import com.chenhao.goods.entity.Brand;
import com.chenhao.goods.entity.Spec;
import com.chenhao.goods.entity.SpecOption;

@ContextConfiguration({"classpath:applicationContext-dubbo-provider.xml","classpath:applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsServiceImplTest {
	@Autowired
	private BrandMapper mapper;
	@Autowired
	private SpecMapper specmapper;
	@Test
	public void testGet() {
		Brand findById = mapper.findById(2);
		System.out.println(findById.toString());
	}
	@Test 
	public void testGetAll() {
		List<Brand> list = mapper.queryAllBrand(new Brand());
		for (Brand brand : list) {
			System.out.println(brand);
		}
	}
	@Test
	public void testList() {
		List<Spec> list = specmapper.list(new SpecOption());
		for (Spec spec : list) {
			System.out.println(spec);
		}
	}
	
}
