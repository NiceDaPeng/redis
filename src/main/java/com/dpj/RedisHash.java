package com.dpj;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class RedisHash {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.1.4",6379);
        System.out.println(jedis.keys("*"));
//        jedis.hset("hash1","key1","value1");
//        jedis.hset("hash1","key2","value2");
//        jedis.hset("hash1","key3","value3");
//        System.out.println(jedis.hget("hash1","key2"));

        System.out.println(jedis.hkeys("hash1"));
//        Map<String,String> map = new HashMap();
//        map.put("key4","value4");
//        map.put("key5","value5");
//        map.put("key6","value6");
//        jedis.hmset("hash1",map);

        //获取hash1中的所有值
        System.out.println(jedis.hvals("hash1"));
        //删除hash1中的key6和其对应的值
        jedis.hdel("hash1","key6");
        //批量查看hash1中的某些键的值
        System.out.println(jedis.hmget("hash1","key1","key2","key3","key4","key5","key6"));
        //查看hash1中的元素的长度
        System.out.println(jedis.hlen("hash1"));

        //查看某个键是否存在
        System.out.println(jedis.exists("key3"));

//        jedis.hset("hash1","key6","10");

        //在hash1中的key6的值上增加3并返回
//        System.out.println(jedis.hincrBy("hash1","key6",3));

        //如果key7不存在则存进去，如果存在则不存
        jedis.hsetnx("hash1","key7","value7");

        System.out.println(jedis.hvals("hash1"));
        System.out.println(jedis.hgetAll("hash1"));

    }
}
