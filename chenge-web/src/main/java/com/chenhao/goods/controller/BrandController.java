package com.chenhao.goods.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenhao.goods.entity.Brand;
import com.chenhao.goods.service.BrandService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("brand")
public class BrandController {
	@Reference
	private BrandService service;
	
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		PageInfo<Brand> list = service.list(new Brand());
		for (Brand b : list.getList()) {
			System.out.println(b);
		}
		return "list";
	}
}
