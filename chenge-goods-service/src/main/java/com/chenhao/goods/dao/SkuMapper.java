package com.chenhao.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chenhao.goods.entity.Sku;
import com.chenhao.goods.entity.SpecOption;
import com.chenhao.goods.entity.SpuVo;

public interface SkuMapper {

	int update(Sku sku);

	int deleteSpecOption(Integer[] ids);
	
	int deleteOneSpecOption(Integer id);
	
	int insertSpecOption(@Param("skuId")Integer id, SpecOption specOption);

	int delete(Integer[] ids);

	int insert(Sku sku);

	

	List<Sku> list(SpuVo vo);
	
	Sku findById(Integer id);
	
	
}
