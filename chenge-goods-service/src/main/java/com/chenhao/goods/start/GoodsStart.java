package com.chenhao.goods.start;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GoodsStart {
	public static void main(String[] args) {
		System.out.println("启动goods服务");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo-provider.xml","classpath:applicationContext-dao.xml");
		context.start();
		System.out.println("启动成功");
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
