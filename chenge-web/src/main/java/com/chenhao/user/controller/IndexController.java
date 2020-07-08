package com.chenhao.user.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenhao.goods.entity.Category;
import com.chenhao.goods.entity.Sku;
import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.entity.SpuVo;
import com.chenhao.goods.service.CategoryService;
import com.chenhao.goods.service.SkuService;
import com.chenhao.goods.service.SpuService;
import com.chenhao.user.entity.EsSpu;
import com.github.pagehelper.PageInfo;


/**
 * 首页相关
 * @author 45466
 *
 */
@Controller
public class IndexController {
	
	@Reference
	private SpuService spuService;
	
	@Reference
	private SkuService skuService;
	
	@Reference
	private CategoryService catService;
	@Autowired
	private ElSearchUtil<EsSpu> esUtil;
	//引入redis模板
	@Autowired
	private RedisTemplate<String, PageInfo<Spu>> redisTemplate;
	@RequestMapping({"/","index"})
	public String index(HttpServletRequest request,SpuVo spuVo) {
		spuVo.setPageSize(10);
		//高频访问，需要缓存
		PageInfo<Spu> pageInfo = null;
		if(spuVo.getPageSize()==1 && spuVo.getCategoryId()==0) {
			Boolean hasKey = redisTemplate.hasKey("firstPage");
			if(hasKey) {
				pageInfo = redisTemplate.opsForValue().get("firstPage");
			}
				
			else {
				pageInfo = spuService.list(spuVo);
				redisTemplate.opsForValue().set("firstPage", pageInfo,3000,TimeUnit.SECONDS);
			}
				
				
		}else {
			pageInfo = spuService.list(spuVo);
			redisTemplate.opsForValue().set("firstPage", pageInfo,3000,TimeUnit.SECONDS);
		}
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		return "index";
	}
	
	
	  @RequestMapping("spu") 
	  public String spuDetail(HttpServletRequest request,int spuId) {
	  
		  // 获取spu 的信息 
		  Spu spu = spuService.getById(spuId); 
		  // 获取sku的列表
		  List<Sku> skuList = skuService.listDetailBySpu(spuId); System.out.println("spu is " +spu); 
		  System.out.println("sku is " + skuList); request.setAttribute("spu", spu); 
		  request.setAttribute("skuList", skuList); return "spudetail"; 
	  }
	 
	
	@RequestMapping("catData")
	@ResponseBody
	public List<Category> getData(){
		// 获取到所有分类的数据
		 List<Category> categories = catService.list(0);
		 return categories;
	}
	@RequestMapping("query")
	public String query(HttpServletRequest request,String keyword,SpuVo vo) {
		Date date = new Date();
		AggregatedPage<EsSpu> page = esUtil.queryObjects(EsSpu.class, vo.getPageNum(), vo.getPageSize(), new String[] {"goodsName","caption","categoryName","brandName"}, keyword);
		
		request.setAttribute("page", page);
		request.setAttribute("spuVo", vo);
		Date date2 = new Date();
		long time=date2.getTime()-date.getTime();
		request.setAttribute("time", time);
		return "query";
	}
}
