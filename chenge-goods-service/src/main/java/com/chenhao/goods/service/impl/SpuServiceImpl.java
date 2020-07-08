package com.chenhao.goods.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.alibaba.fastjson.JSON;
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
	@Autowired
	KafkaTemplate<String , String> kaTemplate;
	
	@Override
	public Integer add(Spu spu) {
		int r= mapper.add(spu);
		if(r>0) {
			int spuId= spu.getId();
			// 
			Spu spu2 = mapper.getById(spuId);
			String spuJson = JSON.toJSONString(spu2);
			kaTemplate.send("hgspu", "addspu",spuJson);
		}
		return r;
	}

	@Override
	public Integer update(Spu spu) {
		return mapper.update(spu);
	}

	@Override
	public Integer delete(Integer[] ids) {
		int n =  mapper.delete(ids);
		if(n>0) {
			String delIdsStr = JSON.toJSONString(ids);
			kaTemplate.send("hgspu", "delspu",delIdsStr);
		}
		return n;
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
