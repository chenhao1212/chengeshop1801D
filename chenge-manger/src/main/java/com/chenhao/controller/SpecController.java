package com.chenhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenhao.goods.entity.Spec;
import com.chenhao.goods.entity.SpecOption;
import com.chenhao.goods.service.SpecService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("spec")
public class SpecController {
	@Reference
	private SpecService specService;
	
	@ResponseBody
	@RequestMapping("addSpec")
	public boolean add(Spec spec) {
		List<SpecOption> optios = spec.getOptios();
		for (int i = optios.size()-1; i >=0; i--) {
			SpecOption specOption = optios.get(i);
			if(specOption.getOptionName()==null || "".equals(specOption.getOptionName())) {
				optios.remove(i);
			}
		}
		int add = specService.add(spec);
		return add>0;
	}
	
	@RequestMapping("toAdd")
	public String toAdd() {
		return "spec/addSpec";
	}
	@ResponseBody
	@RequestMapping("del")
	public boolean delSpec(@RequestParam("id[]")Integer []id) {
		for (Integer integer : id) {
			System.out.println(integer);
		}
		return specService.delete(id)>0;
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,SpecOption option,@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "10")Integer pageSize) {
		PageInfo<Spec> info = specService.list(option, pageNum, pageSize);
		request.setAttribute("pageInfo", info);
		return "spec/list";
	}
	
	@RequestMapping("toUpdate")
	public String toUpdate(Integer id,HttpServletRequest request) {
		Spec byId = specService.getById(id);
		request.setAttribute("spec", byId);
		return "spec/update";
	}
	
	@ResponseBody
	@RequestMapping("Update")
	public boolean Update(Spec spec) {
		List<SpecOption> optios = spec.getOptios();
		for (int i = optios.size()-1; i >=0; i--) {
			SpecOption specOption = optios.get(i);
			if(specOption.getOptionName()==null || "".equals(specOption.getOptionName())) {
				optios.remove(i);
			}
		}
		int update = specService.update(spec);
		return update>0;
	}
	
}
