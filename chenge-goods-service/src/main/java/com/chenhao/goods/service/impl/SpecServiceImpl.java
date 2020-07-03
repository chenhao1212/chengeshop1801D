package com.chenhao.goods.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenhao.goods.dao.SpecMapper;
import com.chenhao.goods.entity.Spec;
import com.chenhao.goods.entity.SpecOption;
import com.chenhao.goods.service.SpecService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService{
	@Autowired
	private SpecMapper mapper;
	
	@Override
	public int add(Spec spec) {
		//先添加主表
		int i=mapper.addSpec(spec);
		//插入子表
		for (SpecOption specOption : spec.getOptios()) {
			specOption.setSpecId(spec.getId());
			mapper.addSpecOption(specOption);
		}
		return i;
	}

	@Override
	public int delete(Integer[] ids) {
		//先删除子表
		int i=mapper.deleteOptions(ids);
		int j=mapper.deleteSpec(ids);
		return i;
	}

	@Override
	public int update(Spec spec) {
		//修改主表
		int i=mapper.updateSpec(spec);
		//删除子表
		mapper.deleteOption(spec.getId());
		//插入子表
		for (SpecOption so : spec.getOptios()) {
			//设置主键
			so.setSpecId(spec.getId());
			mapper.addSpecOption(so);
		}
		return i;
	}

	@Override
	public PageInfo<Spec> list(SpecOption spec, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Spec>(mapper.list(spec));
	}

	@Override
	public Spec getById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findById(id);
	}

	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return mapper.listAll();
	}

}
