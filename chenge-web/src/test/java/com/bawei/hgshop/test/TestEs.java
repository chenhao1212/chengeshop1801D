package com.bawei.hgshop.test;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chenhao.goods.entity.Spu;
import com.chenhao.goods.entity.SpuVo;
import com.chenhao.goods.service.SpuService;
import com.chenhao.user.controller.ElSearchUtil;
import com.chenhao.user.entity.EsSpu;
import com.github.pagehelper.PageInfo;

@ContextConfiguration("classpath:test-consumer.xml")
@RunWith(SpringRunner.class)
public class TestEs {
	
	@Reference
	SpuService spuService;
	
	@Autowired
	ElSearchUtil<EsSpu> esUtil;
	
	@Test
	public void createIndex() {
		
		SpuVo spuVo = new SpuVo();
		
		spuVo.setPageSize(100);
		// 从数据库中获取数据
		PageInfo<Spu> pageInfo = spuService.list(spuVo);
		List<Spu> list = pageInfo.getList();
		for (Spu spu : list) {
			EsSpu esSpu = new EsSpu(spu);
			// 调用工具类保存到ES当中
			esUtil.saveObject(esSpu.getId().toString(), esSpu);
		}
	}

}
