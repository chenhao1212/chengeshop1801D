package com.chenhao.user.service;

import com.chenhao.user.entity.User;

public interface UserService {
	//注册
	User register(User user);
	//登录
	User login(User user);
	//根据名字查找用户
	User getUserByName(String name);
	
	
}
