package com.chenhao.goods.dao;

import java.util.List;

import com.chenhao.goods.entity.Spec;
import com.chenhao.goods.entity.SpecOption;

public interface SpecMapper {

	int addSpec(Spec spec);

	void addSpecOption(SpecOption specOption);

	int deleteOptions(Integer[] ids);

	int deleteSpec(Integer[] ids);

	Spec findById(Integer id);

	List<Spec> list(SpecOption spec);

	int updateSpec(Spec spec);

	void deleteOption(Integer id);
	
	
}
