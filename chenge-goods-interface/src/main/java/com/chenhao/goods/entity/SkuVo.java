package com.chenhao.goods.entity;

import java.io.Serializable;

public class SkuVo extends Sku implements Serializable{
	/**
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pageNum=1;
	private Integer pageSize=10;
	private String orderType="ASC";
	private Integer minPrice;
	private Integer maxPrice;
	private String orderColumn="";
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
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
		return "SkuVo [pageNum=" + pageNum + ", pageSize=" + pageSize + ", orderType=" + orderType + ", orderColumn="
				+ orderColumn + "]";
	}
	public SkuVo(Integer pageNum, Integer pageSize, String orderType, String orderColumn) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.orderType = orderType;
		this.orderColumn = orderColumn;
	}
	public SkuVo() {
		super();
	}
	
}
