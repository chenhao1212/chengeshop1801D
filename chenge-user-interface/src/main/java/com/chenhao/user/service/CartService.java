package com.chenhao.user.service;

import java.util.List;

import com.chenhao.user.entity.Cart;


/**
 * 购物车的服务
 * @author 45466
 *
 */
public interface CartService {
	
	int add(Cart cart);
	
	
	int delete(int[] ids);
	/**
	 * 
	 * @param uid 用户id
	 * @return
	 */
	List<Cart> list(int uid);
	
	List<Cart> ListByIds(int[] ids);
	

	/**
	 * 根据购物车id 生成订单
	 * @param cartIds
	 * @param uid
	 * @return
	 */
	int createOrder(int[] cartIds, String address ,Integer uid);
	

}
