package com.chenhao.goods.service;

import com.chenhao.goods.entity.Sku;
import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.entity.SpuVo;
import com.github.pagehelper.PageInfo;

public interface SkuService {
	Integer add(Sku sku);
	
	Integer update(Sku sku);
	
	
	Integer delete(Integer []ids);
	
	PageInfo<Sku> list(SpuVo vo);
	
	Sku getById(Integer id);
}
