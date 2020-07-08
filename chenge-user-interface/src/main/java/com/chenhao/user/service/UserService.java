package com.chenhao.user.service;

import java.util.List;

import com.chenhao.user.entity.OrderDetail;
import com.chenhao.user.entity.Orderz;
import com.chenhao.user.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
	//注册
	User register(User user);
	//登录
	User login(User user);
	//根据名字查找用户
	User getUserByName(String name);
	
	PageInfo<Orderz> listOrderz(Integer uid, int page);

	List<OrderDetail> listOrderDetail(int oid);
	
}
