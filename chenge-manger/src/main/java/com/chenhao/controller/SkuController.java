package com.chenhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chenhao.goods.entity.Sku;
import com.chenhao.goods.entity.SkuVo;
import com.chenhao.goods.entity.Spec;
import com.chenhao.goods.entity.SpecOption;
import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.service.SkuService;
import com.chenhao.goods.service.SpecService;
import com.chenhao.goods.service.SpuService;
import com.chenhao.utils.FileUtil;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("sku")
public class SkuController {
	@Reference 
	private SpuService spuService;
	@Reference
	private SkuService skuService;
	@Reference
	private SpecService specService;
	@Autowired
	private FileUtil fileUtils;
	@RequestMapping("list")
	public String list_index(HttpServletRequest request,SkuVo vo) {
		PageInfo<Sku> list = skuService.list(vo);
		request.setAttribute("pageInfo", list);
		request.setAttribute("skuVo", vo);
		return "sku/list";
	}
	
	@RequestMapping("toAdd")
	public String toAdd(HttpServletRequest request,Integer spuId) {
		Spu spu = spuService.getById(spuId);
		request.setAttribute("spu", spu);
		
		List<Spec> listAll = specService.listAll();
		request.setAttribute("specs", listAll);
		return "sku/add";
	}
	/**
	 * 添加sku
	 * @param request
	 * @param sku
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Sku sku,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("cartThumbnailFile") MultipartFile cartThumbnailFile ) {
		List<SpecOption> list = sku.getOptions();
		//数据清零一下
		 for (int i = list.size()-1; i >=0; i--) {
			SpecOption option = list.get(i);
			if(null == option.getSpecId() || 0==option.getSpecId()) {
				list.remove(i);
			}
		}
		// 处理图片
		 sku.setImage(fileUtils.upPath(imageFile)); 
		 sku.setCartThumbnail(fileUtils.upPath(cartThumbnailFile)); 
		 
		return skuService.add(sku)>0?"ok":"failed";
	}
	
	@RequestMapping("toUpdate")
	public String toUpdate(HttpServletRequest request,Integer id) {
		
		//
		Sku sku = skuService.getById(id);
		request.setAttribute("sku", sku);
		
		// 获取规格
		List<Spec> specList = specService.listAll();
		request.setAttribute("specList", specList);
		
		return "sku/update";
	}
	
	/**
	 * 添加sku
	 * @param request
	 * @param sku
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,Sku sku,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("cartThumbnailFile") MultipartFile cartThumbnailFile ) {
		List<SpecOption> list = sku.getOptions();
		//数据清零一下
		 for (int i = list.size()-1; i >=0; i--) {
			SpecOption option = list.get(i);
			if(null == option.getSpecId() || 0==option.getSpecId()) {
				list.remove(i);
			}
		}
		// 处理图片
		 sku.setImage(fileUtils.upPath(imageFile)); 
		 sku.setCartThumbnail(fileUtils.upPath(cartThumbnailFile)); 
		 
		return skuService.update(sku)>0?"ok":"failed";
	}
	
	/**
	 * 获取一个规格的所有属性
	 * @param specId
	 * @return
	 */
	@RequestMapping("getSpecOptions")
	@ResponseBody
	public List<SpecOption> getOptions(int specId){
		Spec spec = specService.getById(specId);
		if(spec==null)
			return null;
		return spec.getOptios();
	}
	
	@RequestMapping("del")
	@ResponseBody
	public String del(HttpServletRequest request,@RequestParam("ids[]") Integer[] ids) {
		
		return skuService.delete(ids)>0?"ok":"failed";
		
	}
}
