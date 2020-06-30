package com.chenhao.goods.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.chenhao.goods.dao.SkuMapper;
import com.chenhao.goods.entity.Sku;
import com.chenhao.goods.entity.SpecOption;
import com.chenhao.goods.entity.SpuVo;
import com.chenhao.goods.service.SkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service(interfaceClass = SkuService.class)
public class SkuServiceImpl implements SkuService{
	
	@Autowired
	private SkuMapper mapper;
	@Override
	public Integer add(Sku sku) {
		
		// TODO Auto-generated method stub
				//插入主表 生成主键
				int result = mapper.insert(sku);
				List<SpecOption> options = sku.getOptions();
				//插入子表
				for (SpecOption specOption : options) {
					result+=mapper.insertSpecOption(sku.getId(),specOption);
				}
				
				return result;
	}

	@Override
	public Integer update(Sku sku) {
		// TODO Auto-generated method stub
				//修改主表
				int result = mapper.update(sku);
				// 删除子表的数据
				result += mapper.deleteOneSpecOption(sku.getId());
				
				//重新添加   插入子表
				List<SpecOption> options = sku.getOptions();
				for (SpecOption specOption : options) {
					result+=mapper.insertSpecOption(sku.getId(),specOption);
				}
				return result;
	}

	@Override
	public Integer delete(Integer[] ids) {
		// TODO Auto-generated method stub
				// 先删除子表
				int  result = mapper.deleteSpecOption(ids);
				//再删除主表
				result += mapper.delete(ids);
				
				return result;
	}

	@Override
	public PageInfo<Sku> list(SpuVo vo) {
		// TODO Auto-generated method stub
				PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
				return new PageInfo<Sku>(mapper.list(vo)) ;
	}

	@Override
	public Sku getById(Integer id) {
		// TODO Auto-generated method stub
		return mapper.findById(id);
	}

}
