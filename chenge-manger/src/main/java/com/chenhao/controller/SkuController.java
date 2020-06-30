package com.chenhao.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenhao.goods.entity.SkuVo;
import com.chenhao.goods.service.BrandService;
import com.chenhao.goods.service.SkuService;

@Controller
@RequestMapping("sku")
public class SkuController {
	
	@Reference
	private SkuService skuService;
	
	@Reference
	private BrandService brandService;
	
	@RequestMapping("list")
	public String list_index(HttpServletRequest request,SkuVo vo) {
		
		return "sku/list";
	}
	
	@RequestMapping("toAdd")
	public String toAdd() {
		
		return "sku/add";
	}
}
