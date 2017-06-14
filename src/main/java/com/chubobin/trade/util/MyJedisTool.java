package com.chubobin.trade.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyJedisTool {
	
	public static JedisPoolConfig jpc=new JedisPoolConfig();
	
	public static JedisPool pool=null;
	static{
		jpc.setBlockWhenExhausted(false); // 连接耗尽则阻塞
		jpc.setLifo(true); // 后进先出
		jpc.setMaxIdle(10); // 最大空闲连接数为10
		jpc.setMinIdle(0); // 最小空闲连接数为0
		jpc.setMaxTotal(100); // 最大连接数为100
		jpc.setMaxWaitMillis(-1); // 设置最大等待毫秒数：无限制
		jpc.setMinEvictableIdleTimeMillis(180); // 逐出连接的最小空闲时间：30分钟
		jpc.setTestOnBorrow(true); // 获取连接时是否检查连接的有效性：是
		jpc.setTestWhileIdle(true);
		pool=new JedisPool(jpc,"192.168.137.128",6379);
	}
	
	public static Jedis get_Jedis(){
		
		return pool.getResource();
	}
}
