package com.chenhao.goods.service;

import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.entity.SpuVo;
import com.github.pagehelper.PageInfo;

public interface SpuService {
	
	Integer add(Spu spu);
	
	Integer update(Spu spu);
	
	Integer delete(Integer []ids);
	
	PageInfo<Spu> list(SpuVo vo);
	
	
	Spu getById(Integer id);
}
