package com.chenhao.goods.entity;

import java.io.Serializable;
import java.util.List;

public class Spec implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String specName;
	private List<SpecOption> optios;
	
	public List<SpecOption> getOptios() {
		return optios;
	}
	public void setOptios(List<SpecOption> optios) {
		this.optios = optios;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	@Override
	public String toString() {
		return "Spec [id=" + id + ", specName=" + specName + ", optios=" + optios + "]";
	}
	public Spec(Integer id, String specName, List<SpecOption> optios) {
		super();
		this.id = id;
		this.specName = specName;
		this.optios = optios;
	}
	public Spec() {
		super();
	}
	
}
