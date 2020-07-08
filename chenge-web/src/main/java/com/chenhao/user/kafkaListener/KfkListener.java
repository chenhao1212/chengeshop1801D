package com.chenhao.user.kafkaListener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.chenhao.goods.entity.Spu;
import com.chenhao.user.controller.ElSearchUtil;
import com.chenhao.user.entity.EsSpu;
import com.github.pagehelper.PageInfo;


public class KfkListener implements MessageListener<String, String>{
	@Autowired
	RedisTemplate<String, PageInfo<Spu>> redisTemplate;
	@Autowired
	ElSearchUtil<EsSpu> esUtil;

	public void onMessage(ConsumerRecord<String, String> data) {
		// TODO Auto-generated method stub
				String key = data.key();
				System.out.println(" KfkListener  收到消息 key " + key + " and  value is " + data.value());
				if(key=="addspu") {
					//可能首页数据收到影响
					redisTemplate.delete("firstPage");

					// es 的数据也会受影响
					String spuJsonStr = data.value();
					Spu spu = JSON.parseObject(spuJsonStr, Spu.class);
					EsSpu esSpu = new EsSpu(spu);
					esUtil.saveObject(esSpu.getId().toString(), esSpu);
				}else if(key == "delspu") {
					System.out.println("删除功能未完成");
				}

	}
	
}
