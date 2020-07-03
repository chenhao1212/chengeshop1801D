package com.chenhao.goods.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.chenhao.goods.entity.Sku;
import com.chenhao.goods.entity.SkuVo;
import com.chenhao.goods.entity.SpecOption;

public interface SkuMapper {

	int update(Sku sku);
	
	int deleteSpecOption(Integer ...ids);
	
	int insertSpecOption(@Param("skuId")Integer id, @Param("opt")SpecOption specOption);

	int delete(Integer[] ids);

	int insert(Sku sku);

	List<Sku> list(SkuVo vo);
	
	Sku findById(Integer id);

	List<Sku> ListBySpuId(int spuId);
	
	
}
