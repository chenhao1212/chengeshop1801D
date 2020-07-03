package com.chenhao.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chenhao.goods.entity.Brand;
import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.entity.SpuVo;
import com.chenhao.goods.service.BrandService;
import com.chenhao.goods.service.SpuService;
import com.chenhao.utils.FileUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("spu")
public class SpuController {
	@Reference
	private SpuService spuService;
	
	@Reference
	private BrandService brandService;
	@Autowired
	private FileUtil fileUtil;
	
	@RequestMapping("list")
	public String list_index(HttpServletRequest request,SpuVo vo) {
		 vo.setPageSize(15);
		 PageInfo<Spu> pageinfo = spuService.list(vo);
		 PageInfo<Brand> list = brandService.list(new Brand());
		 request.setAttribute("info", pageinfo);
		 request.setAttribute("vo", vo);
		 request.setAttribute("brands", list);
		return "spu/list";
	}
	
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request) {
		 PageInfo<Brand> list = brandService.list(new Brand());
		 request.setAttribute("brands", list);
		 return "spu/add";
	}
	@ResponseBody
	@RequestMapping("add")
	public boolean add(HttpServletRequest request,Spu spu,@RequestParam("myFile")MultipartFile file) {
		String upPath = fileUtil.upPath(file);
		spu.setSmallPic(upPath);
		return spuService.add(spu)>0;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdate(HttpServletRequest request,Spu spu) {
		Spu spu2 = spuService.getById(spu.getId());
		request.setAttribute("spu1", spu2);
		System.out.println(spu2);
		PageInfo<Brand> pageInfo = brandService.list(new Brand());
		request.setAttribute("brands", pageInfo.getList());
		
		return "spu/update";
	}
	@ResponseBody
	@RequestMapping("update")
	public boolean update(HttpServletRequest request,Spu spu,@RequestParam("myFile")MultipartFile file) {
		spu.setSmallPic(fileUtil.upPath(file));
		return spuService.update(spu)>0;
	}
	
}
