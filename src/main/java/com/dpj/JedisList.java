package com.dpj;

import redis.clients.jedis.Jedis;

public class JedisList {

    public static void main(String[] args) {
//////////////////////////////////////////////////////redis数据结构--List///////////////////////
        Jedis jedis = new Jedis("192.168.1.4",6379);
//        jedis.lpush("list1","value1","value2","value3");
//        System.out.println(jedis.lrange("list1",0,-1));

//        jedis.rpush("list2","value1","value2","value3");
        System.out.println(jedis.lrange("list2",0,-1));
//        String list1 = jedis.lpop("list1");
//        System.out.println(list1);
        System.out.println(jedis.lrange("list1",0,-1));

//        System.out.println(jedis.rpop("list1"));
        System.out.println(jedis.lrange("list1",0,-1));
        System.out.println(jedis.llen("list1"));

        //获取2号索引的值
        System.out.println(jedis.lindex("list1",2));
//        jedis.lrem("list1",2,"value1");
        System.out.println(jedis.lrange("list1",0,-1));

        //截取0索引-2索引的值保留，其余的全部删除
//        System.out.println(jedis.ltrim("list1",0,2));
//        System.out.println(jedis.lrange("list1",0,-1));

        //从列表头插入信息
//        jedis.lpushx("list1","reids","nice");
//
//        //从列表尾部插入信息
//        jedis.rpushx("list1","我是后面的","我也是从后插入的");
        System.out.println(jedis.lrange("list1",0,-1));

        jedis.lset("list1",2,"10");
        System.out.println(jedis.lrange("list1",0,-1));



    }
}
