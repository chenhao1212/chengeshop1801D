package com.chenhao.goods.entity;

import java.io.Serializable;

public class SpuVo extends Spu implements Serializable{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer pageNum=1;
	private Integer pageSize=10;
	private String orderType="ASC";
	private String orderColumn="";
	
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "SpuVo [pageNum=" + pageNum + ", pageSize=" + pageSize + ", orderType=" + orderType + ", orderColumn="
				+ orderColumn + "]";
	}
	public SpuVo(Integer id, String goodsName, String isMarketable, Integer brandId, String caption, Integer categoryId,
			String smallPic, Integer pageNum, Integer pageSize) {
		super(id, goodsName, isMarketable, brandId, caption, categoryId, smallPic);
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	public SpuVo(Integer id, String goodsName, String isMarketable, Integer brandId, String caption, Integer categoryId,
			String smallPic) {
		super(id, goodsName, isMarketable, brandId, caption, categoryId, smallPic);
	}
	public SpuVo() {
		
	}
	
	
	
}
