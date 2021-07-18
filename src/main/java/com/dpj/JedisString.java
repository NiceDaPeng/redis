package com.dpj;

import redis.clients.jedis.Jedis;

import java.util.List;

public class JedisString {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.1.4",6379);

        ////////////////////////////////////////////jedis对字符串的操作////////////////////////////////////////
        jedis.select(0);
//        System.out.println(jedis.keys("*"));
        jedis.set("key1","nice");
        System.out.println(jedis.get("key1"));
        jedis.set("key2","20");
        System.out.println(jedis.incr("key2"));
        System.out.println(jedis.decr("key2"));
        System.out.println(jedis.incrBy("key2",3));
        System.out.println(jedis.decrBy("key2",2));
        jedis.set("key3","hello Redis");
        //获取全部的key3中的0索引开始到3索引结束的截取值
        String key3 = jedis.getrange("key3", 0, 3);
        System.out.println(key3);
        //将key3的值0索引位置的字符更改为nice
        jedis.setrange("key3", 0, "nice");
        key3 = jedis.get("key3");
        System.out.println(key3);

        List<String> mget = jedis.mget("key1", "key2", "key3");
        for (String value :
                mget) {
            System.out.println(value);
        }
        jedis.mset("key4","value4","key5","value5","key6","value6");
        List<String> mget1 = jedis.mget("key4", "key5", "key6");
        for (String value :
                mget1) {
            System.out.println(value);
        }

        System.out.println(jedis.getSet("key4","IAmANewValue"));
        System.out.println(jedis.get("key4"));
///////////////////////////////////////////////////////List 操作/////////////////////////////////////////




        //创建时就要想着关闭
        jedis.close();
    }
}
