package com.chenhao.goods.dao;

import java.util.List;

import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.entity.SpuVo;

public interface SpuMapper {
	Integer add(Spu spu);
	
	Integer update(Spu spu);
	
	Integer delete(Integer []ids);
	
	List<Spu> list(SpuVo vo);
	
	Spu getById(Integer id);
}
