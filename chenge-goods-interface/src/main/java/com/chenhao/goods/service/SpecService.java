package com.chenhao.goods.service;

import com.chenhao.goods.entity.Spec;
import com.chenhao.goods.entity.SpecOption;
import com.github.pagehelper.PageInfo;

public interface SpecService {
	//添加
	int add(Spec spec);
	//删除
	int delete(Integer []ids);
	//修改
	int update(Spec spec);
	//列表
	PageInfo<Spec> list(SpecOption spec,Integer pageNum,Integer pageSize);
	
	
	Spec getById(Integer id);
}
