package com.chenhao.user.entity;

import java.io.Serializable;
import java.util.Date;

import com.chenhao.goods.entity.Sku;

/**
 * 购物车
 * @author 45466
 *
 */
public class Cart  implements Serializable{
	
	private Integer id;
	private int uid;//用户id
	private int skuid;//sku 的id
	private int pnum; // 购买数量
	private Date createtime;//添加的时间
	private Date updatetime;//最后的修改时间
	
	private Sku sku;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSkuid() {
		return skuid;
	}
	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", uid=" + uid + ", skuid=" + skuid + ", pnum=" + pnum + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", sku=" + sku + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + skuid;
		result = prime * result + uid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (skuid != other.skuid)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	public Sku getSku() {
		return sku;
	}
	public void setSku(Sku sku) {
		this.sku = sku;
	}
	
	
	
	
	


}
