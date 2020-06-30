package com.chenhao.goods.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenhao.goods.dao.SpuMapper;
import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.entity.SpuVo;
import com.chenhao.goods.service.SpuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService{
	@Autowired
	private SpuMapper mapper;
	
	
	@Override
	public Integer add(Spu spu) {
		return mapper.add(spu);
	}

	@Override
	public Integer update(Spu spu) {
		return mapper.update(spu);
	}

	@Override
	public Integer delete(Integer[] ids) {
		return mapper.delete(ids);
	}
	
	@Override
	public PageInfo<Spu> list(SpuVo vo) {
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		return new PageInfo<Spu>(mapper.list(vo)) ;
	}

	@Override
	public Spu getById(Integer id) {
		return mapper.getById(id);
	}
	
}
