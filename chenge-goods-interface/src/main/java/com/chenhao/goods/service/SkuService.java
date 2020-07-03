package com.chenhao.goods.service;

import java.util.List;

import com.chenhao.goods.entity.Sku;
import com.chenhao.goods.entity.SkuVo;
import com.github.pagehelper.PageInfo;

public interface SkuService {
	Integer add(Sku sku);
	
	Integer update(Sku sku);
	
	Integer delete(Integer []ids);
	
	PageInfo<Sku> list(SkuVo vo);
	
	Sku getById(Integer id);
	
	// 根据spu 获取sku的集合，同时包含规格详情
	List<Sku> listDetailBySpu(int spuId);
	
}
